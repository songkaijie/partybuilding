package com.changfa.frame.zuul.filter;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.changfa.frame.zuul.entity.AccessFrequency;
import com.changfa.frame.zuul.entity.AccessList;
import com.changfa.frame.zuul.entity.AccessPeriod;
import com.changfa.frame.zuul.entity.RestrictionMode;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean shouldFilter() {
        log.info("------------------shouldFilter-------------------");
        return true;
    }


    @Override
    public String filterType() {
        log.info("------------------filterType-------------------");
        return "pre";
    }

    @Override
    public int filterOrder() {
        log.info("------------------filterOrder-------------------");
        return 0;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("------------------run-------------------");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();

        //群组认证,添加Basic Auth认证信息
        ctx.addZuulRequestHeader("Authorization", "Basic " + getBase64Credentials("fast", "fast"));

        try {

            //从数据库表获取白名单信息
//			wList = getWhiteList();
//			bList = getBlackList();
//			AccessIp(wList,bList);
            //黑白名单验证
            BlackAndWhite();
            //次数限制验证
            RestrictionNumber();
            //时间限制验证
            TimeLimit();


        } catch (Exception e) {
            log.error("限制错误");
        }
        return null;
    }

    private String getBase64Credentials(String username, String password) {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    /**
     * 获取Ip地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public void TimeLimit() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        String requestURI = req.getRequestURI();
        String flg = requestURI.substring(1, requestURI.length());
        String urls = flg.substring(flg.indexOf("/"));
        String[] urlList = requestURI.split("/");


        AccessPeriod per = new AccessPeriod();
        RestrictionMode restric = new RestrictionMode();

        List<AccessPeriod> prelist = new ArrayList<AccessPeriod>();

        try {
            prelist = queryPeriodList(per);
            if (prelist == null || prelist.size() < 1) {
                log.info("请求服务信息为：[{}],无此服务时间限制信息", requestURI);
            } else {
                for (int i = 0; i < prelist.size(); i++) {
                    AccessPeriod period = prelist.get(i);
                    if (period.getServerName().equals(urlList[1])) {
                        if (period.getApiName().contains("{")) {
                            period.setApiName(period.getApiName().substring(0, period.getApiName().indexOf("{")) + "id");
                        }
                        String ac = urls.substring(urls.lastIndexOf("/") + 1, urls.length());
                        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
                        if (pattern.matcher(ac).matches()) {
                            urls = urls.substring(0, urls.lastIndexOf("/")) + "/id";
                        }
                        if (urls.contains(period.getApiName())) {
                            restric.setRestrictionId(period.getRestrictionId());
                            restric = queryRestricBean(restric);
                            String model = restric.getTimeModel();

                            Date date = new Date();
                            //当前时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                            String dateTime = df.format(date);
                            //星期
                            SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
                            String currWeek = dateFm.format(date);
                            String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
                            //月份
                            Calendar cale = Calendar.getInstance();
                            int month = cale.get(Calendar.MONTH) + 1;
                            //小时
                            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
                            int Hou = cal.get(Calendar.HOUR);

                            if ("0".equals(period.getType())) {
                                if ("M".equals(model)) {
                                    String mon = restric.getRestrictionMonth();
                                    String[] mos = mon.split(",");
                                    for (int j = 0; j < mos.length; j++) {
                                        String ho = String.valueOf(month);
                                        if (ho.equals(mos[j])) {
                                            log.info("请求服务信息为：[{}],该服务在" + ho + "月允许访问", requestURI);
                                        }
                                    }
                                } else if ("T".equals(model)) {
                                    String start = restric.getStartTime();
                                    String end = restric.getEndTime();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date begin = sdf.parse(start);
                                    Date over = sdf.parse(end);

                                    Calendar dte = Calendar.getInstance();
                                    dte.setTime(date);

                                    Calendar after = Calendar.getInstance();
                                    after.setTime(begin);

                                    Calendar before = Calendar.getInstance();
                                    before.setTime(over);

                                    if (dte.after(after) && dte.before(before)) {
                                        log.info("请求服务信息为：[{}],该服务在" + dateTime + "允许访问", requestURI);
                                    }

                                } else if ("H".equals(model)) {
                                    String hour = restric.getRestrictionHour();
                                    String[] hours = hour.split(",");
                                    for (int j = 0; j < hours.length; j++) {
                                        String ho = String.valueOf(Hou);
                                        if (ho.equals(hours[j])) {
                                            log.info("请求服务信息为：[{}],该服务在" + ho + "点允许访问", requestURI);
                                        }
                                    }
                                } else if ("W".equals(model)) {
                                    String wk = restric.getRestrictionWeek();
                                    String[] ws = wk.split(",");
                                    for (int j = 0; j < ws.length; j++) {
                                        int w = Integer.parseInt(ws[j]);
                                        String da = weekDays[w - 1];
                                        if (currWeek.equals(da)) {
                                            log.info("请求服务信息为：[{}],该服务在" + da + "允许访问", requestURI);
                                        }
                                    }
                                }
                            } else if ("1".equals(period.getType())) {
                                if ("M".equals(model)) {
                                    String mon = restric.getRestrictionMonth();
                                    String[] mos = mon.split(",");
                                    for (int j = 0; j < mos.length; j++) {
                                        String ho = String.valueOf(month);
                                        if (ho.equals(mos[j])) {
                                            log.info("请求服务信息为：[{}],该服务在" + ho + "月不允许访问", requestURI);
                                            ctx.setResponseStatusCode(401);
                                            ctx.setSendZuulResponse(false);
                                            ctx.setResponseBody("requestURI is in black lists!");
                                        }
                                    }

                                } else if ("T".equals(model)) {
                                    String start = restric.getStartTime();
                                    String end = restric.getEndTime();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date begin = sdf.parse(start);
                                    Date over = sdf.parse(end);

                                    Calendar dte = Calendar.getInstance();
                                    dte.setTime(date);

                                    Calendar after = Calendar.getInstance();
                                    after.setTime(begin);

                                    Calendar before = Calendar.getInstance();
                                    before.setTime(over);

                                    if (dte.after(after) && dte.before(before)) {
                                        log.info("请求服务信息为：[{}],该服务在" + dateTime + "不允许访问", requestURI);
                                        ctx.setResponseStatusCode(401);
                                        ctx.setSendZuulResponse(false);
                                        ctx.setResponseBody("requestURI is in black lists!");
                                    }

                                } else if ("H".equals(model)) {
                                    String hour = restric.getRestrictionHour();
                                    String[] hours = hour.split(",");
                                    for (int j = 0; j < hours.length; j++) {
                                        String ho = String.valueOf(Hou);
                                        if (ho.equals(hours[j])) {
                                            log.info("请求服务信息为：[{}],该服务在" + ho + "点不允许访问", requestURI);
                                            ctx.setResponseStatusCode(401);
                                            ctx.setSendZuulResponse(false);
                                            ctx.setResponseBody("requestURI is in black lists!");
                                        }
                                    }
                                } else if ("W".equals(model)) {
                                    String wk = restric.getRestrictionWeek();
                                    String[] ws = wk.split(",");
                                    for (int j = 0; j < ws.length; j++) {
                                        int w = Integer.parseInt(ws[j]);
                                        String da = weekDays[w - 1];
                                        if (currWeek.equals(da)) {
                                            log.info("请求服务信息为：[{}],该服务在" + da + "不允许访问", requestURI);
                                            ctx.setResponseStatusCode(401);
                                            ctx.setSendZuulResponse(false);
                                            ctx.setResponseBody("requestURI is in black lists!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            log.error("时间限制逻辑错误");
        }

    }


    public void RestrictionNumber() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        String requestURI = req.getRequestURI();
        String[] urlList = requestURI.split("/");
        AccessFrequency afre = new AccessFrequency();
        try {
            List<AccessFrequency> fres = queryFreList(afre);
            if (fres == null || fres.size() < 1) {
                log.info("请求服务信息为：[{}],无此服务次数限制信息", requestURI);
            } else {
                for (int i = 0; i < fres.size(); i++) {
                    AccessFrequency fre = fres.get(i);
                    if (fre.getServerName().equals(urlList[1])) {
                        if (fre.getApiName().contains("{")) {
                            fre.setApiName(fre.getApiName().substring(0, fre.getApiName().indexOf("{")) + "id");
                        }
                        String ac = requestURI.substring(requestURI.lastIndexOf("/") + 1, requestURI.length());
                        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
                        if (pattern.matcher(ac).matches()) {
                            requestURI = requestURI.substring(0, requestURI.lastIndexOf("/")) + "/id";
                        }
                        if (requestURI.contains(fre.getApiName())) {
                            if ("0".equals(fre.getSurplusTimes())) {
                                log.info("请求服务信息为：[{}],该服务剩余请求次数为0", requestURI);
                                ctx.setResponseStatusCode(401);
                                ctx.setSendZuulResponse(false);
                                ctx.setResponseBody("IpAddr is in black lists!");
                            } else {
                                int nsur = (Integer.parseInt(fre.getSurplusTimes())) - 1;
                                fre.setSurplusTimes(String.valueOf(nsur));
                                updateFre(fre);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("次数限制逻辑错误");
        }


    }

    public void BlackAndWhite() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        String requestURI = req.getRequestURI();
        String ip = this.getIpAddr(req);
        AccessList aclist = new AccessList();
        aclist.setIpAddress(ip);
        try {
            List<AccessList> accs = queryAccList(aclist);
            if (accs == null || accs.size() < 1) {
                log.info("请求IP地址为：[{}],无此ip限制信息", ip);
            } else {
                for (int i = 0; i < accs.size(); i++) {
                    if ("0".equals(accs.get(i).getType()) && accs.get(i).getServerName() == null && accs.get(i).getApiName() == null) {
                        log.info("请求IP地址为：[{}],IP校验通过", ip);
                        break;
                    } else if ("1".equals(accs.get(i).getType()) && accs.get(i).getServerName() == null && accs.get(i).getApiName() == null) {
                        log.info("请求IP地址为：[{}],IP地址校验不通过！！！已被加入黑名单", ip);
                        ctx.setResponseStatusCode(401);
                        ctx.setSendZuulResponse(false);
                        ctx.setResponseBody("IpAddr is in black lists!");
                        break;
                    } else if ("0".equals(accs.get(i).getType()) && accs.get(i).getServerName() != null && accs.get(i).getApiName() == null) {
                        if (requestURI.contains(accs.get(i).getServerName())) {
                            log.info("请求服务地址为：[{}],校验通过", requestURI);
                            break;
                        } else {
                            continue;
                        }
                    } else if ("1".equals(accs.get(i).getType()) && accs.get(i).getServerName() != null && accs.get(i).getApiName() == null) {
                        if (requestURI.contains(accs.get(i).getServerName())) {
                            log.info("请求服务地址为：[{}],校验不通过！！！已被加入黑名单", requestURI);
                            ctx.setResponseStatusCode(401);
                            ctx.setSendZuulResponse(false);
                            ctx.setResponseBody("requestURI is in black lists!");
                            break;
                        } else {
                            continue;
                        }
                    } else if ("0".equals(accs.get(i).getType()) && accs.get(i).getServerName() != null && accs.get(i).getApiName() != null) {
                        if (requestURI.contains(accs.get(i).getApiName())) {
                            log.info("请求服务地址为：[{}],校验通过", requestURI);
                            break;
                        } else {
                            continue;
                        }
                    } else if ("1".equals(accs.get(i).getType()) && accs.get(i).getServerName() != null && accs.get(i).getApiName() != null) {
                        if (requestURI.contains(accs.get(i).getApiName())) {
                            log.info("请求服务地址为：[{}],校验不通过！！！已被加入黑名单", requestURI);
                            ctx.setResponseStatusCode(401);
                            ctx.setSendZuulResponse(false);
                            ctx.setResponseBody("requestURI is in black lists!");
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("黑白名单限制逻辑错误");
        }
    }


    public List<AccessList> queryAccList(AccessList entity) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("select id,ip_address,server_name,api_name,type,sts,date_format(sts_date,'%Y-%m-%d %H:%i:%s')sts_date,date_format(create_date,'%Y-%m-%d %H:%i:%s')create_date ");
        sql.append("FROM access_list ");
        sql.append("WHERE 1=1");

        List<AccessList> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
                if (StringUtils.isNotBlank(entity.getIpAddress())) {
                    sql.append(" AND ip_address=?");
                    params.add(entity.getIpAddress());
                }
                if (StringUtils.isNotBlank(entity.getId())) {
                    sql.append(" AND ID=?");
                    params.add(entity.getId());
                }
                if (StringUtils.isNotBlank(entity.getServerName())) {
                    sql.append(" AND SERVER_NAME=?");
                    params.add(entity.getServerName());
                }
                if (StringUtils.isNotBlank(entity.getApiName())) {
                    sql.append(" AND API_NAME=?");
                    params.add(entity.getApiName());
                }
                if (StringUtils.isNotBlank(entity.getType())) {
                    sql.append(" AND type=?");
                    params.add(entity.getType());
                }
//                	if (StringUtils.isNotBlank(entity.getSts())) {
                sql.append(" AND STS='A'");
//                    	params.add(entity.getSts());
//    				}
            } else {
                sql.append(" AND 1=2");
            }
            log.info(sql.toString());
            resultList = jdbcTemplate.query(sql.toString(),
                    params.toArray(),
                    new BeanPropertyRowMapper<AccessList>(AccessList.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("查询access_list错误：{}", e.getMessage());
        }
        return resultList;
    }

    public List<AccessFrequency> queryFreList(AccessFrequency entity) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ID,SERVER_NAME,API_NAME,TOTAL_TIMES,SURPLUS_TIMES,PRE_ALARM_THRESHOLD,ALARM_THRESHOLD,STS,date_format(STS_DATE,'%Y-%m-%d %H:%i:%s')STS_DATE,date_format(CREATE_DATE,'%Y-%m-%d %H:%i:%s')CREATE_DATE ");
        sql.append("FROM ACCESS_FREQUENCY ");
        sql.append("WHERE 1=1");

        List<AccessFrequency> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
                if (StringUtils.isNotBlank(entity.getId())) {
                    sql.append(" AND ID=?");
                    params.add(entity.getId());
                }
                if (StringUtils.isNotBlank(entity.getServerName())) {
                    sql.append(" AND SERVER_NAME=?");
                    params.add(entity.getServerName());
                }
                if (StringUtils.isNotBlank(entity.getApiName())) {
                    sql.append(" AND API_NAME=?");
                    params.add(entity.getApiName());
                }
                if (StringUtils.isNotBlank(entity.getTotalTimes())) {
                    sql.append(" AND TOTAL_TIMES=?");
                    params.add(entity.getTotalTimes());
                }
                if (StringUtils.isNotBlank(entity.getSurplusTimes())) {
                    sql.append(" AND SURPLUS_TIMES=?");
                    params.add(entity.getSurplusTimes());
                }
                if (StringUtils.isNotBlank(entity.getPreAlarmThreshold())) {
                    sql.append(" AND PRE_ALARM_THRESHOLD=?");
                    params.add(entity.getPreAlarmThreshold());
                }
                if (StringUtils.isNotBlank(entity.getAlarmThreshold())) {
                    sql.append(" AND ALARM_THRESHOLD=?");
                    params.add(entity.getAlarmThreshold());
                }
                sql.append(" AND STS='A'");
                if (StringUtils.isNotBlank(entity.getStsDate())) {
                    sql.append(" AND STS_DATE=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                    params.add(entity.getStsDate());
                }
                if (StringUtils.isNotBlank(entity.getCreateDate())) {
                    sql.append(" AND CREATE_DATE=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                    params.add(entity.getCreateDate());
                }
            } else {
                sql.append(" AND 1=2");
            }
            log.info(sql.toString());
            resultList = jdbcTemplate.query(sql.toString(),
                    params.toArray(),
                    new BeanPropertyRowMapper<AccessFrequency>(AccessFrequency.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("查询ACCESS_FREQUENCY错误：{}", e.getMessage());
        }
        return resultList;
    }


    public int updateFre(AccessFrequency entity) throws Exception {
        int rowsAffected = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ACCESS_FREQUENCY SET ");
        // 判断主键是否为空
        List<Object> params = new ArrayList<Object>();
        try {
            sql.append("SURPLUS_TIMES=?,");
            params.add(entity.getSurplusTimes());

            sql.deleteCharAt(sql.length() - 1);
            sql.append(" WHERE ID=?");
            params.add(entity.getId());
            log.info(sql.toString());
            rowsAffected = jdbcTemplate.update(sql.toString(), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("更新ACCESS_FREQUENCY错误：{}", e.getMessage());
        }
        return rowsAffected;
    }


    public List<AccessPeriod> queryPeriodList(AccessPeriod entity) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ID,SERVER_NAME,API_NAME,RESTRICTION_ID,RESTRICTION_DESCRIPTION,TYPE,STS,date_format(STS_DATE,'%Y-%m-%d %H:%i:%s')STS_DATE,date_format(CREATE_DATE,'%Y-%m-%d %H:%i:%s')CREATE_DATE ");
        sql.append("FROM ACCESS_PERIOD ");
        sql.append("WHERE 1=1");

        List<AccessPeriod> resultList = null;
        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
                if (StringUtils.isNotBlank(entity.getId())) {
                    sql.append(" AND ID=?");
                    params.add(entity.getId());
                }
                if (StringUtils.isNotBlank(entity.getServerName())) {
                    sql.append(" AND SERVER_NAME=?");
                    params.add(entity.getServerName());
                }
                if (StringUtils.isNotBlank(entity.getApiName())) {
                    sql.append(" AND API_NAME=?");
                    params.add(entity.getApiName());
                }
                if (StringUtils.isNotBlank(entity.getRestrictionId())) {
                    sql.append(" AND RESTRICTION_ID=?");
                    params.add(entity.getRestrictionId());
                }
                if (StringUtils.isNotBlank(entity.getRestrictionDescription())) {
                    sql.append(" AND RESTRICTION_DESCRIPTION=?");
                    params.add(entity.getRestrictionDescription());
                }
                if (StringUtils.isNotBlank(entity.getType())) {
                    sql.append(" AND TYPE=?");
                    params.add(entity.getType());
                }
                sql.append(" AND STS='A'");
                if (StringUtils.isNotBlank(entity.getStsDate())) {
                    sql.append(" AND STS_DATE=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                    params.add(entity.getStsDate());
                }
                if (StringUtils.isNotBlank(entity.getCreateDate())) {
                    sql.append(" AND CREATE_DATE=str_to_date(?,'%Y-%m-%d %H:%i:%s')");
                    params.add(entity.getCreateDate());
                }
            } else {
                sql.append(" AND 1=2");
            }
            log.info(sql.toString());
            resultList = jdbcTemplate.query(sql.toString(),
                    params.toArray(),
                    new BeanPropertyRowMapper<AccessPeriod>(AccessPeriod.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("查询ACCESS_PERIOD错误：{}", e.getMessage());
        }
        return resultList;
    }

    public RestrictionMode queryRestricBean(RestrictionMode entity) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT RESTRICTION_ID,TIME_MODEL,DATE_FORMAT(START_TIME,'%Y-%m-%d %H:%i:%s')START_TIME,DATE_FORMAT(END_TIME,'%Y-%m-%d %H:%i:%s')END_TIME,RESTRICTION_HOUR,RESTRICTION_DAY,RESTRICTION_WEEK,RESTRICTION_MONTH,STS,DATE_FORMAT(STS_DATE,'%Y-%m-%d %H:%i:%s')STS_DATE,DATE_FORMAT(CREATE_DATE,'%Y-%m-%d %H:%i:%s')CREATE_DATE ");
        sql.append("FROM RESTRICTION_MODE ");
        sql.append("WHERE 1=1");

        List<Object> params = new ArrayList<Object>();
        try {
            if (entity != null) {
                sql.append(" AND RESTRICTION_ID=?");
                params.add(entity.getRestrictionId());
            } else {
                sql.append(" AND 1=2");
            }
            log.info(sql.toString());
            entity = jdbcTemplate.queryForObject(sql.toString(),
                    params.toArray(),
                    new BeanPropertyRowMapper<RestrictionMode>(RestrictionMode.class));
        } catch (EmptyResultDataAccessException e) {
        } catch (IncorrectResultSizeDataAccessException e) {
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error("查询RESTRICTION_MODE错误：{}", e.getMessage());
        }
        return entity;
    }
}

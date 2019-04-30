
package com.changfa.frame.website.controller;

import com.changfa.frame.website.common.JsonReturnUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Api(tags = "测试", description = "test")
public class TestSpringCloud {

    private static Logger log = LoggerFactory.getLogger(TestSpringCloud.class);

    /* *
     * 会员个人资料
     * @Author        zyj
     * @Date          2018/10/15 12:38
     * @Description
     * */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(value = "获取信息")
    public String userInfo(@RequestBody Map<String, Object> map) {
        try {
            log.info("会员资料：" + "token:" + map);
            Map<String, Object> mapReturn = new HashMap<>();
            mapReturn.put("token", map.get("token"));
            return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", mapReturn).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }
}

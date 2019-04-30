package com.changfa.frame.website.controller.article;


import com.changfa.frame.data.dto.article.CmsArticleDTO;
import com.changfa.frame.website.common.JsonReturnUtil;
import com.changfa.frame.website.controller.TestSpringCloud;
import com.changfa.frame.website.service.article.CmsArticleService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/article")
@Api(tags = "内容管理", description = "article")
public class ArticleController {

    private static Logger log = LoggerFactory.getLogger(TestSpringCloud.class);

    @Autowired
    private CmsArticleService cmsArticleService;

    @RequestMapping(value = "/getArticleList", method = RequestMethod.POST)
    @ApiOperation(value = "获取文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "专题ID", required = false, dataType = "Integer", paramType = "query")
    })
    public String getArticleList(@RequestBody Map<String, Object> map) {
        try {
            log.info("获取文章列表：" + "token:" + map.get("token"));
            Map<String, Object> cmsArticleDTOList = cmsArticleService.getArticleList(Integer.valueOf(map.get("categoryId").toString()));
            return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", cmsArticleDTOList).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }


    @RequestMapping(value = "/getArticleDetail", method = RequestMethod.POST)
    @ApiOperation(value = "获取文章详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "articleId", value = "专题ID", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "articleType", value = "专题ID", required = false, dataType = "Integer", paramType = "query")
    })
    public String getArticleDetail(@RequestBody Map<String, Object> map) {
        try {
            log.info("获取文章详情：" + "token:" + map.get("token"));
            CmsArticleDTO cmsArticleDTO = cmsArticleService.getArticleDTOById(Integer.valueOf(map.get("articleId").toString()), map.get("articleType").toString());
            return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", cmsArticleDTO).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }


    @RequestMapping(value = "/getSubjectList", method = RequestMethod.POST)
    @ApiOperation(value = "获取专题列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "专题ID", required = false, dataType = "Integer", paramType = "query")
    })
    public String getSubjectList(@RequestBody Map<String, Object> map) {
        try {
            log.info("获取专题列表：" + "token:" + map.get("token"));
            List<CmsArticleDTO> cmsSubjectList = cmsArticleService.getCmsSubjectList(Integer.valueOf(map.get("categoryId").toString()));
            return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", cmsSubjectList).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }


    @RequestMapping(value = "/getCmsSubjcetArticleList", method = RequestMethod.POST)
    @ApiOperation(value = "获取专题内容列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "subjectId", value = "专题ID", required = false, dataType = "Integer", paramType = "query")
    })
    public String getCmsSubjcetArticleList(@RequestBody Map<String, Object> map) {
        try {
            log.info("获取专题内容：" + "token:" + map.get("token"));
            List<CmsArticleDTO> cmsArticleDTOList = cmsArticleService.getCmsSubjcetArticleList(Integer.valueOf(map.get("subjectId").toString()));
            return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", cmsArticleDTOList).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }


    @RequestMapping(value = "/getSubjectArticle", method = RequestMethod.POST)
    @ApiOperation(value = "获取专题内容详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "articleId", value = "专题文章ID", required = false, dataType = "Integer", paramType = "query")
    })
    public String getSubjectArticle(@RequestBody Map<String, Object> map) {
        try {
            log.info("获取专题内容：" + "token:" + map.get("token"));
            CmsArticleDTO cmsArticleDTO = cmsArticleService.getCmsSubjectArticleDetail(Integer.valueOf(map.get("articleId").toString()));
            return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", cmsArticleDTO).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }


}

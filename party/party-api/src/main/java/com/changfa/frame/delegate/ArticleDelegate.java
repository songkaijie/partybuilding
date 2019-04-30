package com.changfa.frame.delegate;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "party-zuul/party-cms-provider")
public interface ArticleDelegate {

    @RequestMapping(value = "/article/getArticleList", method = RequestMethod.POST)
    public String getArticleList(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/article/getArticleDetail", method = RequestMethod.POST)
    public String getArticleDetail(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/article/getSubjectList", method = RequestMethod.POST)
    public String getSubjectList(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/article/getSubjectArticle", method = RequestMethod.POST)
    public String getSubjectArticle(@RequestBody Map<String, Object> map);

}



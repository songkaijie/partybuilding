package com.changfa.frame.website.controller.article;


import com.changfa.frame.delegate.ArticleDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private static Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleDelegate articleDelegate;

    @RequestMapping(value = "/getArticleList", method = RequestMethod.POST)
    public String userInfo(@RequestBody Map<String, Object> map) {
        return articleDelegate.getArticleList(map);
    }

    @RequestMapping(value = "/getArticleDetail", method = RequestMethod.POST)
    public String getArticleDetail(@RequestBody Map<String, Object> map) {
        return articleDelegate.getArticleDetail(map);
    }


    @RequestMapping(value = "/getSubjectList", method = RequestMethod.POST)
    public String getSubjectList(@RequestBody Map<String, Object> map) {
        return articleDelegate.getSubjectList(map);
    }

    @RequestMapping(value = "/getSubjectArticle", method = RequestMethod.POST)
    public String getSubjectArticle(@RequestBody Map<String, Object> map) {
        return articleDelegate.getSubjectArticle(map);
    }

}

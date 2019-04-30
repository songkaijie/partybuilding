package com.changfa.frame.website.controller.user;

import com.changfa.frame.data.entity.user.UserArticleHistory;
import com.changfa.frame.delegate.UserArticleHistoryDelegate;
import com.changfa.frame.website.controller.article.ArticleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
@RestController
@RequestMapping("/user/article")
public class UserArticleHistoryController {
    private static Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private UserArticleHistoryDelegate userArticleHistoryDelegate;

    @RequestMapping(value = "/findHistoryByToken", method = RequestMethod.POST)
    public String findHistoryByToken(@RequestBody Map<String, Object> map) {
        return userArticleHistoryDelegate.findHistoryByToken(map);
    }
}

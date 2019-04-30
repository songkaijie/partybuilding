package com.changfa.frame.delegate;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ArticleDelegateFallbackFactory implements FallbackFactory<ArticleDelegate> {
    @Override
    public ArticleDelegate create(Throwable cause) {
        return new ArticleDelegate() {
            @Override
            public String getArticleList(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String getArticleDetail(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String getSubjectList(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String getSubjectArticle(Map<String, Object> map) {
                return "服务发生错误";
            }
        };
    }
}

package com.changfa.frame.delegate;

import com.changfa.frame.data.entity.user.UserArticleHistory;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
@Component
public class UserArticleHistoryFallbackFactory implements FallbackFactory<UserArticleHistoryDelegate> {

    @Override
    public UserArticleHistoryDelegate create(Throwable throwable) {
        return new UserArticleHistoryDelegate() {
            @Override
            public String findHistoryByToken(Map<String, Object> map) {
                return "服务发生错误";
            }
        };
    }
}

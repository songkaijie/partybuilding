package com.changfa.frame.delegate;

import com.changfa.frame.common.JsonReturnUtil;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Component
public class UserDelegateFallbackFactory implements FallbackFactory<UserDelegate> {
    @Override
    public UserDelegate create(Throwable cause) {
        return new UserDelegate() {
            @Override
            public String findByToken(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String findUserInfoByToken(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String updateUserInfo(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String findPartyInfoByToken(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String updatePartyInfo(Map<String, Object> map) {
                return "服务发生错误";
            }

            @Override
            public String updateIcon(MultipartFile file, Map<String, Object> map) {
                return "服务发生错误";
            }


        };
    }
}

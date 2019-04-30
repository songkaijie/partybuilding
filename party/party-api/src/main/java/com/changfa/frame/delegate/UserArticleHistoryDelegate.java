package com.changfa.frame.delegate;

import com.changfa.frame.data.entity.user.UserArticleHistory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
@FeignClient(name = "party-zuul/party-system-provider")
public interface UserArticleHistoryDelegate {

    @RequestMapping(value = "user/article/findHistoryByToken", method = RequestMethod.POST)
    public String findHistoryByToken(@RequestBody Map<String, Object> map);
}

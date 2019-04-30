package com.changfa.frame.website.controller.user;

import com.changfa.frame.data.dto.user.UserArticleHistoryDTO;
import com.changfa.frame.data.entity.user.User;
import com.changfa.frame.website.common.JsonReturnUtil;
import com.changfa.frame.website.service.user.UserArticleHistoryService;
import com.changfa.frame.website.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.Validate;
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
@Api(tags = "用户浏览记录", description = "user-article-history")
public class UserArticleHistoryController {
    private static Logger log = LoggerFactory.getLogger(UserArticleHistoryController.class);
    @Autowired
    private UserArticleHistoryService userArticleHistoryService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findHistoryByToken", method = RequestMethod.POST)
    @ApiOperation(value = "根据token查询用户浏览记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户ID", required = false, dataType = "String", paramType = "query")
    })
    public String findHistoryByToken(@RequestBody Map<String, Object> map) {
        try {
            log.info("根据token获取用户：" + "token:" + map.get("token"));
            User user = userService.findByToken(map.get("token").toString());
            Validate.notNull(user, "用户信息不存在");
            List<UserArticleHistoryDTO> userArticleHistories = userArticleHistoryService.findByUserId(user.getId());
            if (userArticleHistories.size() != 0) {
                return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", userArticleHistories).toString();
            } else {
                return JsonReturnUtil.getJsonReturn(1, "100", "用户token不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }
}

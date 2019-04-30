package com.changfa.frame.website.controller.user;


import com.changfa.frame.data.dto.user.UserInfoDTO;
import com.changfa.frame.data.entity.user.User;
import com.changfa.frame.website.common.JsonReturnUtil;
import com.changfa.frame.website.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户", description = "user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/findByToken", method = RequestMethod.POST)
    @ApiOperation(value = "根据token获取用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户ID", required = false, dataType = "String", paramType = "query")
    })
    public String findByToken(@RequestBody Map<String, Object> map) {
        try {
            log.info("根据token获取用户：" + "token:" + map.get("token"));
            User user = userService.findByToken(map.get("token").toString());
            if (user != null) {
                return JsonReturnUtil.getJsonReturn(0, "200", "查询成功");
            } else {
                return JsonReturnUtil.getJsonReturn(1, "100", "用户token不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/findUserInfoByToken", method = RequestMethod.POST)
    @ApiOperation(value = "根据token获取用户基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户ID", required = false, dataType = "String", paramType = "query")
    })
    public String findUserInfoByToken(@RequestBody Map<String, Object> map) {
        try {
            log.info("根据token获取用户基本信息：" + "token:" + map.get("token"));
            UserInfoDTO userInfoDTO = userService.findUserInfoByToken(map.get("token").toString());
            if (userInfoDTO != null) {
                return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", userInfoDTO).toString();
            } else {
                return JsonReturnUtil.getJsonReturn(1, "100", "用户token不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "更新个人基本信息")
    public String updateUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        try {
            log.info("根据token更新个人基本信息：" + "token:" + userInfoDTO.getToken());
            userService.updateUserInfo(userInfoDTO);
            return JsonReturnUtil.getJsonReturn(0, "200", "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/updateIcon", method = RequestMethod.POST)
    @ApiOperation(value = "上传头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "头像", required = false, dataType = "MultipartFile", paramType = "query"),
    })
    public String updateIcon(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            String filePath = userService.updateIcon(file);
            Map<String, Object> map = new HashMap();
            map.put("filePath", filePath);
            return JsonReturnUtil.getJsonObjectReturn(0, "200", "修改头像成功", map).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/findPartyInfoByToken", method = RequestMethod.POST)
    @ApiOperation(value = "根据token获取党员详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户ID", required = false, dataType = "String", paramType = "query")
    })
    public String findPartyInfoByToken(@RequestBody Map<String, Object> map) {
        try {
            log.info("根据token获取党员详细信息：" + "token:" + map.get("token"));
            UserInfoDTO userInfoDTO = userService.findPartyInfoByToken(map.get("token").toString());
            if (userInfoDTO != null) {
                return JsonReturnUtil.getJsonObjectReturn(0, "200", "查询成功", userInfoDTO).toString();
            } else {
                return JsonReturnUtil.getJsonReturn(1, "100", "用户token不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }

    @RequestMapping(value = "/updatePartyInfo", method = RequestMethod.POST)
    @ApiOperation(value = "更新党员信息")
    public String updatePartyInfo(@RequestBody UserInfoDTO userInfoDTO) {
        try {
            log.info("根据token更新党员详细信息：" + "token:" + userInfoDTO.getToken());
            userService.updatePartyInfo(userInfoDTO);
            return JsonReturnUtil.getJsonReturn(0, "200", "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonReturnUtil.getJsonReturn(500, e.getMessage());
        }
    }
}

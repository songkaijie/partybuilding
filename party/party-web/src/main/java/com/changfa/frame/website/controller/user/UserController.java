package com.changfa.frame.website.controller.user;

import com.changfa.frame.delegate.UserDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserDelegate userDelegate;

    @RequestMapping(value = "/findByToken", method = RequestMethod.POST)
    public String findByToken(@RequestBody Map<String, Object> map) {
        return userDelegate.findByToken(map);
    }

    @RequestMapping(value = "/findPartyInfoByToken", method = RequestMethod.POST)
    public String findPartyInfoByToken(@RequestBody Map<String, Object> map) {
        return userDelegate.findPartyInfoByToken(map);
    }

    @RequestMapping(value = "/updatePartyInfo", method = RequestMethod.POST)
    public String updatePartyInfo(@RequestBody Map<String, Object> map) {
        return userDelegate.updatePartyInfo(map);
    }

    @RequestMapping(value = "/findUserInfoByToken", method = RequestMethod.POST)
    public String findUserInfoByToken(@RequestBody Map<String, Object> map) {
        return userDelegate.findUserInfoByToken(map);
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody Map<String, Object> map) {
        return userDelegate.updateUserInfo(map);
    }

    @RequestMapping(value = "/updateIcon", method = RequestMethod.POST)
    public String updateIcon(@RequestParam("file") MultipartFile file, @RequestBody Map<String, Object> map) {
        return userDelegate.updateIcon(file, map);
    }
}

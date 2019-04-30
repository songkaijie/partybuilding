package com.changfa.frame.delegate;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(name = "party-zuul/party-system-provider")
public interface UserDelegate {

    @RequestMapping(value = "/user/findByToken", method = RequestMethod.POST)
    public String findByToken(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/user/updateUserInfo", method = RequestMethod.POST)
    public String findUserInfoByToken(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/user/updateUserInfo", method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/user/findPartyInfoByToken", method = RequestMethod.POST)
    public String findPartyInfoByToken(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/user/updatePartyInfo", method = RequestMethod.POST)
    public String updatePartyInfo(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/user/updateIcon", method = RequestMethod.POST)
    public String updateIcon(@RequestParam("file") MultipartFile file, @RequestBody Map<String, Object> map);


}

package com.changfa.frame.zuul.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@PropertySource({"classpath:/list.properties"})
public class PropConf {

    @Value("${black.list}")
    private String blackList;
    @Value("${white.list}")
    private String whiteList;


    public String getBlackList() {
        return blackList;
    }


    public void setBlackList(String blackList) {
        this.blackList = blackList;
    }


    public String getWhiteList() {
        return whiteList;
    }


    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList;
    }


    public void show() {
        System.out.println("blackList --- > " + blackList);
        System.out.println("b --- > " + whiteList);
    }
}
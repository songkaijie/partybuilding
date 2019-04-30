package com.changfa.frame.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.changfa.frame.zuul.filter.AccessFilter;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication extends SpringBootServletInitializer {

    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZuulApplication.class);
    }

}

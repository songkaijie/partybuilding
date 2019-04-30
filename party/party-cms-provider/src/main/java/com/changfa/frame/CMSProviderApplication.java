package com.changfa.frame;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@SpringBootApplication
@ServletComponentScan
@EnableAsync
@EnableScheduling
@EnableDiscoveryClient
@EnableWebMvc
public class CMSProviderApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(CMSProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(final ObjectProvider<List<HttpMessageConverter<?>>> convertersProvider) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<HttpMessageConverter<?>> converters = convertersProvider.getIfAvailable();
                System.out.print(converters.size());
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CMSProviderApplication.class);
    }

//    @Bean
//    public ObjectMapper objectMapper()
//    {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.findAndRegisterModules();
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,
//                false);
//        return mapper;
//    }
}

package com.changfa.frame.eureka.listener;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;


@Component
public class EurekaStateListener {

    private final static Logger logger = LoggerFactory.getLogger(EurekaStateListener.class);

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        logger.info("服务{}已下线", event.getAppName());
        logger.info("server地址信息{}", event.getServerId());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        logger.info("服务{}进行注册", instanceInfo.getAppName() + "  " + instanceInfo.getHostName() + "  " + instanceInfo.getIPAddr() + "  " + instanceInfo.getPort());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
//        logger.info("服务{}进行续约", event.getServerId() +"  "+ event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("注册中心启动,{}", dateformat.format(System.currentTimeMillis()));
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("注册中心服务端启动,{}", dateformat.format(System.currentTimeMillis()));
    }

}

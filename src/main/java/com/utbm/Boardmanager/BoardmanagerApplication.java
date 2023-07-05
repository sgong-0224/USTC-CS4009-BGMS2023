package com.utbm.Boardmanager;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

//使用技术:
//数据库：MySQL
//后端框架: SpringBoot
//HTML模板: ThymeLeaf
//持久层: Mybatis
//UI: Bootstrap
//登录验证和用户权限: SpringSecurity
@SpringBootApplication
@ServletComponentScan("com.utbm.Boardmanager.config")
public class BoardmanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoardmanagerApplication.class, args);
    }

}
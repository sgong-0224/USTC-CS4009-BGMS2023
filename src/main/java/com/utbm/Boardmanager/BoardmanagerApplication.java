package com.utbm.Boardmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//项目实现:
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

package com.utbm.Boardmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.utbm.Boardmanager.config")
public class BoardmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardmanagerApplication.class, args);
    }

}

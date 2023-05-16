package com.utbm.Boardmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private com.utbm.Boardmanager.mapper.PlayerMapper PlayerMapper;

    @RequestMapping({"/", "/index"})
    public String login(HttpSession session) {
        return "index";
    }

    @RequestMapping({"/toLoginPage"})
    public String toLoginPage() {
        return "login";
    }


}

package com.utbm.Boardmanager.controller;

import com.utbm.Boardmanager.pojo.Player;
import com.utbm.Boardmanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private com.utbm.Boardmanager.mapper.PlayerMapper playerMapper;
    @Autowired
    private com.utbm.Boardmanager.mapper.UserMapper userMapper;
    @RequestMapping({"/", "/index"})
    public String login(HttpSession session) {
        return "index";
    }

    @RequestMapping({"/toLoginPage"})
    public String toLoginPage() {
        return "login";
    }
    @RequestMapping("/toRegisterPage")
    public String toRegisterPage(){
        return "register";
    }
    @RequestMapping("/register")
    public String RegisterUser(){
        User tUser = new User();
        Player tPlayer = new Player();
        userMapper.addUser(tUser);
        playerMapper.addPlayer(tPlayer);
        return "/toLoginPage";
    }
}

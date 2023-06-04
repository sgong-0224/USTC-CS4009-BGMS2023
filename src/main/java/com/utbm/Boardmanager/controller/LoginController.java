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
    @RequestMapping("/toRegisterPage2")
    public String toRegisterPage2(){
        return "registerplayer";
    }
    @RequestMapping("/registerUser")
    public String RegisterUser(User User){
        userMapper.addUser(User);
        return "/toRegisterPage2";
    }
    @RequestMapping("/register_Player")
    public String RegisterPlayer(Player Player){
        playerMapper.addPlayer(Player);
        return "/toLoginPage";
    }
}

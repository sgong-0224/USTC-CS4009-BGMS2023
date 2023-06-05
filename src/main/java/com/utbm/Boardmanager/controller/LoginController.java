package com.utbm.Boardmanager.controller;

import com.utbm.Boardmanager.pojo.Player;
import com.utbm.Boardmanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private com.utbm.Boardmanager.mapper.PlayerMapper playerMapper;
    @Autowired
    private com.utbm.Boardmanager.mapper.UserMapper userMapper;
    @RequestMapping({"/", "/index"})
    public String login(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String name = (String) session.getAttribute("name");
        if(playerMapper.getPlayerInfo(username)==null
                && !Objects.equals(username, "admin")
                && !Objects.equals(name, "admin")
           ){
            String request="redirect:/toRegisterPage2/"+username;
            return request;
        }else {
            return "index";
        }
    }

    @RequestMapping({"/toLoginPage"})
    public String toLoginPage() {
        return "login";
    }
    @RequestMapping("/toRegisterPage")
    public String toRegisterPage(){
        return "register";
    }

    @RequestMapping("/toRegisterException")
    public String toRegisterException(){
        return "register_except";
    }
    @RequestMapping("/register")
    public String RegisterUser(User User, Model model){
        if(userMapper.getUserByUsername(User.getUsername())==null){
            userMapper.addUser(User);
            User tUser = userMapper.getUserByUsername(User.getUsername());
            model.addAttribute("tUser",tUser);
            String request="redirect:/toRegisterPage2/"+tUser.getUsername();
            return request;
        }else{
            return "redirect:/toRegisterException";
        }
    }

    @RequestMapping("/toRegisterPage2/{username}")
    public String toRegisterPage2(@PathVariable("username") String username,Model model){
        User tUser = userMapper.getUserByUsername(username);
        model.addAttribute("tUser",tUser);
        return "register2";
    }

    @RequestMapping("/register/{username}")
    public String RegisterPlayer(Player Player, Model model){
        playerMapper.addPlayer(Player);
        return "redirect:/toLoginPage";
    }
}
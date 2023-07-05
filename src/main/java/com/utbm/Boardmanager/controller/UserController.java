package com.utbm.Boardmanager.controller;

import com.utbm.Boardmanager.mapper.PlayerMapper;
import com.utbm.Boardmanager.mapper.UserMapper;
import com.utbm.Boardmanager.pojo.Player;
import com.utbm.Boardmanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PlayerMapper playerMapper;
    @RequestMapping("/changePasswordAuth")
    public String toChangePasswordPage(String username,String password) {
        User User=userMapper.getUserByUsername(username);
        String pwd=User.getPassword();
        String targetpwd = pwd.replace("{bcrypt}","");
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        if(encoder.matches(password,targetpwd)){
            return "newpasswd";
        }else{
            return "passworderr";
        }
    }
    @RequestMapping("/toChPwdPage")
    public String toChangePasswordPage() {
        return "password";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session, String password) {
        String username = (String) session.getAttribute("username");
        userMapper.changePassword(username,"{bcrypt}"+passwordEncoder.encode(password));
        return "redirect:/toLoginPage";
    }

    @RequestMapping("/checkPassword")
    @ResponseBody
    public String checkPassword(@RequestParam("password") String password, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String realPassword = userMapper.getPassword(username);
        if (realPassword.equals(password))
            return "1";
        else
            return "0";
    }
}

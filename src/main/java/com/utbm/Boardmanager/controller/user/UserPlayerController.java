package com.utbm.Boardmanager.controller.user;

import com.utbm.Boardmanager.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserPlayerController {

    @Autowired
    private com.utbm.Boardmanager.mapper.PlayerMapper PlayerMapper;

    @RequestMapping("/toInfoPage")
    public String toInfoPage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        Player info = PlayerMapper.getPlayerInfo(username);
        model.addAttribute("info", info);
        return "user/Player_info";
    }

    @RequestMapping("/info/update")
    public String update(Player Player) {
        PlayerMapper.updateInfo(Player);
        return "redirect:/index";
    }
}

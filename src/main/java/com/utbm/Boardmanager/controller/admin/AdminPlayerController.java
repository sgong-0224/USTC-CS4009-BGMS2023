package com.utbm.Boardmanager.controller.admin;

import com.utbm.Boardmanager.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/Player")
public class AdminPlayerController {

    @Autowired
    private com.utbm.Boardmanager.mapper.PlayerMapper PlayerMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Player> Players = PlayerMapper.getAllPlayer();
        model.addAttribute("Players", Players);
        return "admin/Players";
    }
}

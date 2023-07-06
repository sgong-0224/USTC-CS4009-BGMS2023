package com.utbm.Boardmanager.controller.user;

import com.utbm.Boardmanager.mapper.NotificationMapper;
import com.utbm.Boardmanager.pojo.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/Notification")
public class UserNotificationController {
    @Autowired
    private com.utbm.Boardmanager.mapper.NotificationMapper notificationMapper;
    @RequestMapping("/getOwnNotification")
    public String getOwnNotification(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<Notification> notifications = notificationMapper.getOwnNotification(username);
        model.addAttribute("notifications", notifications);
        return "user/ownNotification";
    }
}

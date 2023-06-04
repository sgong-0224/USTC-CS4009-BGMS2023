package com.utbm.Boardmanager.controller.admin;

import com.utbm.Boardmanager.mapper.NotificationMapper;
import com.utbm.Boardmanager.pojo.Notification;
import com.utbm.Boardmanager.mapper.RecordMapper;
import com.utbm.Boardmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/Notification")
public class AdminNotificationController {
    @Autowired
    private com.utbm.Boardmanager.mapper.NotificationMapper notificationMapper;
    @Autowired
    private com.utbm.Boardmanager.mapper.RecordMapper recordMapper;
    @RequestMapping("/getAll")
    public String getAllNotification(Model model) {
        List<Notification> notifications = notificationMapper.getAllNotification();
        model.addAttribute("notifications", notifications);
        //debug:
        // System.out.println(notifications); //返回数据
        //debug end
        return "admin/notifications";
    }
    @RequestMapping("send/{sernum}")
    public String sendNotification(@PathVariable("sernum") long sernum,Model model) {
        Record temprecord=recordMapper.getRecordbySernum(sernum);
        notificationMapper.SendNotification(temprecord);
        List<Notification> notifications = notificationMapper.getAllNotification();
        model.addAttribute("notifications", notifications);
        return "admin/notifications";
    }
    @RequestMapping("delete/{message_id}")
    public String delNotification(@PathVariable("message_id") long message_id,Model model) {
        notificationMapper.delNotification(message_id);
        List<Notification> notifications = notificationMapper.getAllNotification();
        model.addAttribute("notifications", notifications);
        return "admin/notifications";
    }
}

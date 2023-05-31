package com.utbm.Boardmanager.controller.user;

import com.utbm.Boardmanager.mapper.BoardMapper;
import com.utbm.Boardmanager.mapper.RecordMapper;
import com.utbm.Boardmanager.pojo.Board;
import com.utbm.Boardmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/record")
public class UserRecordController {
    @Autowired
    private RecordMapper recordMapper;
    private BoardMapper boardMapper;

    @RequestMapping("/getOwnRecord")
    public String ownRecord(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "user/ownRecord";
    }
    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "user/Record_add";
    }

    @RequestMapping("/add")
    public String add(Record Record,HttpSession session,Model model) {
        long sernum=recordMapper.addRecord(Record);
        //Record tempRecord=recordMapper.getRecordbySernum(sernum);
        //boardMapper.SetBorrowed(boardMapper.getBoardById(String.valueOf(tempRecord.getBoardId())));//null?
        String username = (String) session.getAttribute("username");
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "user/ownRecord";
    }
}

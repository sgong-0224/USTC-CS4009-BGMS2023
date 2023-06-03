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
    @Autowired
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
        long serial1=Record.getSernum();
        Record tempRecord=recordMapper.getRecordbySernum(serial1);
        String bid=String.valueOf(tempRecord.getBoardId());
        boardMapper.SetBorrowed(boardMapper.getBoardById(bid));
        //debug:
        //System.out.println(""+serial1);
        //System.out.println(""+tempRecord.getBoardId());
        //System.out.println(""+bid);
        //debug end
        String username = (String) session.getAttribute("username");
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "user/ownRecord";
    }


}

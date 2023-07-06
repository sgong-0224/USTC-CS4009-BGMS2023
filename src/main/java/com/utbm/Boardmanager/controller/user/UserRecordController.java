package com.utbm.Boardmanager.controller.user;

import com.utbm.Boardmanager.mapper.BoardMapper;
import com.utbm.Boardmanager.mapper.PlayerMapper;
import com.utbm.Boardmanager.mapper.RecordMapper;
import com.utbm.Boardmanager.pojo.Board;
import com.utbm.Boardmanager.pojo.Player;
import com.utbm.Boardmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private PlayerMapper playerMapper;

    @RequestMapping("/getOwnRecord")
    public String ownRecord(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "user/ownRecord";
    }
    @RequestMapping("/toAddPage/{boardid}/{username}")
    public String toAddPage(Model model, @PathVariable("boardid") String boardid,@PathVariable("username") String username) {
        Board Board = boardMapper.getBoardById(boardid);
        Player Player = playerMapper.getPlayerInfo(username);
        model.addAttribute("Player",Player);
        model.addAttribute("Board", Board);
        return "user/Record_add";
    }

    @RequestMapping("/add")
    public String add(Record Record, HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        recordMapper.addRecord(Record);
        long sernum=Record.getSernum();
        Record tempRecord=recordMapper.getRecordbySernum(sernum);
        String rawtime = tempRecord.getBackDate();
        String formattime = rawtime.replace("T"," ");
        recordMapper.updateBackTime(sernum,formattime);
        String bid=String.valueOf(tempRecord.getBoardId());
        boardMapper.SetBorrowed(boardMapper.getBoardById(bid));
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "user/ownRecord";
    }

    @RequestMapping("/toReturnPage/{sernum}")
    public String toReturnPage(Model model, @PathVariable("sernum") long sernum) {
        Record Record = recordMapper.getRecordbySernum(sernum);
        model.addAttribute("Record", Record);
        return "user/Record_return";
    }
    @RequestMapping("/return")
    public String ReturnRecord(Record Record,HttpSession session,Model model) {
        String bid=String.valueOf(Record.getBoardId());
        recordMapper.updateRecord(Record);
        Board rBoard=boardMapper.getBoardById(bid);
        boardMapper.SetReturned(rBoard);
        String username = (String) session.getAttribute("username");
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "user/ownRecord";
    }

    @RequestMapping("/toExtendPage/{sernum}")
    public String toExtendPage(Model model, @PathVariable("sernum") long sernum) {
        Record Record = recordMapper.getRecordbySernum(sernum);
        model.addAttribute("Record", Record);
        return "user/Record_extend";
    }
    @RequestMapping("/extend")
    public String ExtendRecord(Record Record,HttpSession session,Model model) {
        recordMapper.updateRecord(Record);
        long sernum=Record.getSernum();
        String rawtime = Record.getBackDate();
        String formattime = rawtime.replace("T"," ");
        recordMapper.updateBackTime(sernum,formattime);
        String username = (String) session.getAttribute("username");
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "user/ownRecord";
    }
}

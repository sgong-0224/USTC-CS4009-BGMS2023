package com.utbm.Boardmanager.controller.admin;

import com.utbm.Boardmanager.mapper.RecordMapper;
import com.utbm.Boardmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/record")
public class AdminRecordController {
    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Record> records = recordMapper.getAllRecord();
        model.addAttribute("records", records);
        return "admin/records";
    }
    @RequestMapping("/delete/{sernum}")
    public String delete(@PathVariable("sernum") long sernum,Model model) {
        recordMapper.delRecord(sernum);
        List<Record> records = recordMapper.getAllRecord();
        model.addAttribute("records", records);
        return "admin/records";
    }
}

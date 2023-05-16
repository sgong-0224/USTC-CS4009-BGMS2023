package com.utbm.Boardmanager.controller.admin;

import com.utbm.Boardmanager.mapper.BoardMapper;
import com.utbm.Boardmanager.pojo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/Board")
public class AdminBoardController {

    @Autowired
    private BoardMapper BoardMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Board> Boards = BoardMapper.getAllBoard();
        model.addAttribute("Boards", Boards);
        return "admin/Boards";
    }

    @RequestMapping("/info/{id}")
    public String info(Model model, @PathVariable("id") String id) {
        Board Board = BoardMapper.getBoardById(id);
        model.addAttribute("Board", Board);
        return "admin/Board_info";
    }

    @RequestMapping("/toEditPage/{id}")
    public String toEditPage(Model model, @PathVariable("id") String id) {
        Board Board = BoardMapper.getBoardById(id);
        model.addAttribute("Board", Board);
        return "admin/Board_edit";
    }

    @RequestMapping("/update")
    public String update(Board Board) {
        BoardMapper.updateBoard(Board);
        return "redirect:/admin/Board/getAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        BoardMapper.deleteBoard(id);
        return "redirect:/admin/Board/getAll";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "admin/Board_add";
    }

    @RequestMapping("/add")
    public String add(Board Board) {
        BoardMapper.addBoard(Board);
        return "redirect:/admin/Board/getAll";
    }

    @RequestMapping("/search")
    public String search(String keyword, Model model) {
        List<Board> Boards = BoardMapper.searchBoard(keyword);
        model.addAttribute("Boards", Boards);
        return "admin/Board_search_result";
    }
}

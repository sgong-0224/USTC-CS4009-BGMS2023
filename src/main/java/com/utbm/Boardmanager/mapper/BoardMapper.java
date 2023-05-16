package com.utbm.Boardmanager.mapper;

import com.utbm.Boardmanager.pojo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    List<Board> getAllBoard();
    Board getBoardById(String id);
    void updateBoard(Board Board);
    void deleteBoard(long id);
    void addBoard(Board Board);
    List<Board> searchBoard(String keyword);
}

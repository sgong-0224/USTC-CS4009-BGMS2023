package com.utbm.Boardmanager.mapper;

import com.utbm.Boardmanager.pojo.Player;
import com.utbm.Boardmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PlayerMapper {
    List<Player> getAllPlayer();
    String getPlayerName(String PlayerId);
    Player getPlayerInfo(String PlayerId);
    void updateInfo(Player Player);
    void addPlayer(Player Player);
    void delPlayer(String PlayerId);
}

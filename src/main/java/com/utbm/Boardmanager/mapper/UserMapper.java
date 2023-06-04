package com.utbm.Boardmanager.mapper;

import com.utbm.Boardmanager.pojo.Board;
import com.utbm.Boardmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User getUserByUsername(String username);
    void changePassword(String username, String newPassword);
    String getPassword(String username);
    void addUser(User User);
}

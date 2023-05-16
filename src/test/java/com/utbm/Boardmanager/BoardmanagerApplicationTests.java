package com.utbm.Boardmanager;

import com.utbm.Boardmanager.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardmanagerApplicationTests {

    @Autowired
    private BoardMapper BoardMapper;

    @Test
    void contextLoads() {

    }

}

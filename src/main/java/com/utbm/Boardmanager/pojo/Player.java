package com.utbm.Boardmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int PlayerId;
    private String name;
    private String sex;
    private String telcode;
}

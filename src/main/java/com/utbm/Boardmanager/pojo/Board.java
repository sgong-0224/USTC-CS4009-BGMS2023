package com.utbm.Boardmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private long BoardId;
    private String name;
    private String Category;
    private String PlayerCount;
    private String Introduction;
    private String StoreLocation;
    private int state;
}

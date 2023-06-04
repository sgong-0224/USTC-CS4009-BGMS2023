package com.utbm.Boardmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private long sernum;
    private long BoardId;
    private String PlayerId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String lendDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String backDate;
    private int State;
}

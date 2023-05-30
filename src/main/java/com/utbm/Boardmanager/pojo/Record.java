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
    private int PlayerId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date lendDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date backDate;
}

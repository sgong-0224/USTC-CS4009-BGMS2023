package com.utbm.Boardmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private long MessageId;
    private String PlayerId;
    private long Sernum;
    private String Content;
}

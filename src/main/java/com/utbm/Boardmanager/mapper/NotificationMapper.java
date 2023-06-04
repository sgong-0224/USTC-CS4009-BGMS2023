package com.utbm.Boardmanager.mapper;

import com.utbm.Boardmanager.pojo.Notification;
import com.utbm.Boardmanager.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface NotificationMapper {
    List<Notification> getOwnNotification(String PlayerId);
    List<Notification> getAllNotification();
    void SendNotification(Record Record);
    void delNotification(long MessageId);
}

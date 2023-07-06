package com.utbm.Boardmanager.mapper;

import com.utbm.Boardmanager.pojo.Board;
import com.utbm.Boardmanager.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecordMapper {
    List<Record> getAllRecord();
    List<Record> getOwnRecord(String PlayerId);
    long addRecord(Record Record);
    void delRecord(long sernum);
    Record getRecordbySernum(long sernum);
    void ReturnRecord(Record Record);
    void updateRecord(Record Record);
    void updateBackTime(long sernum,String backtime);
}

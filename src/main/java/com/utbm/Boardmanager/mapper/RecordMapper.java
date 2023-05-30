package com.utbm.Boardmanager.mapper;

import com.utbm.Boardmanager.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecordMapper {
    List<Record> getAllRecord();
    List<Record> getOwnRecord(String PlayerId);

}

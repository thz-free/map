package com.example.map.dao;

import com.example.map.domain.dbinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IDbInfoDao {
    //发布代办事件
    void setDbInfo(dbinfo dbInfo) throws Exception;
}

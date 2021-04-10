package com.example.map.dao;

import com.example.map.domain.dninfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IDnInfoDao {
//   发布代拿事件
    void setDnInfo(dninfo dnInfo) throws Exception;
}

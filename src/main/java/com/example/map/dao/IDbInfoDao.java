package com.example.map.dao;

import com.example.map.domain.dbinfo;
import com.example.map.domain.dninfo;
import com.example.map.domain.orderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IDbInfoDao {
    //发布代办事件
    void setDbInfo(dbinfo dbInfo) throws Exception;
    //设置订单
    void  setOrderInfo(orderinfo orderInfo)throws Exception;
    //查询代办事件
    String findByIdDbaffairs(int id) throws Exception;
    //查询代拿
    List<orderinfo> findByType(int type)throws Exception;
}

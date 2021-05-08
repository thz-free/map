package com.example.map.service;

import com.example.map.domain.dbinfo;
import com.example.map.domain.orderinfo;

import java.util.List;

public interface DbInfoService {
    void setDbInfo(dbinfo dbInfo)throws Exception;
    //设置订单
    void  setOrderInfo(orderinfo orderInfo)throws Exception;
    //设置代拿订单
    void  setOrderInfo2(orderinfo orderInfo)throws Exception;
    //查询代办事件
    String findByIdDbaffairs(int id) throws Exception;
    //查询代拿
    List<orderinfo> findByType(int type)throws Exception;
}

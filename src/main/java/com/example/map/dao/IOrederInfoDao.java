package com.example.map.dao;

import com.example.map.domain.orderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IOrederInfoDao {
    //生成订单表
    void setOrderInfo(orderinfo orderInfo);
}

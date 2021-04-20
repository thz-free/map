package com.example.map.dao;

import com.example.map.domain.orderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IOrderInfoDao {
    //生成订单表
    void setOrderInfo(orderinfo orderInfo);
    //根据id查询订单
    orderinfo selectOrderInfo(Integer id) throws Exception;
    //查询用户所有订单
    List<orderinfo> selectAllOrder(Integer user_id) throws Exception;
    //更新订单状态
    void updateOrderState(orderinfo orderinfo) throws Exception;
    //查询用户所有抢单
    List<orderinfo> selectGrapOrder(Integer grapuser_id) throws Exception;
}

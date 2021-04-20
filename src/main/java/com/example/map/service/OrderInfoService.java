package com.example.map.service;

import com.example.map.domain.orderinfo;

import java.util.List;

public interface OrderInfoService {
    void setOrderInfo(orderinfo orderInfo);
    orderinfo selectOrderInfo(Integer id) throws Exception;
    List<orderinfo> selectAllOrder(Integer userid) throws Exception;
    void updateOrderState(orderinfo orderinfo) throws Exception;
    List<orderinfo> selectGrapOrder(Integer grapuser_id) throws Exception;
}

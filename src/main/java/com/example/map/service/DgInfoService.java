package com.example.map.service;

import com.example.map.domain.dginfo;
import com.example.map.domain.orderinfo;

public interface DgInfoService {
    void setDgInfo(dginfo dgInfo) throws Exception;
    //设置订单
    void  setOrderInfo(orderinfo orderInfo)throws Exception;
}

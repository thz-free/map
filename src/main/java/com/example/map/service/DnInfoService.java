package com.example.map.service;

import com.example.map.domain.dninfo;
import com.example.map.domain.orderinfo;

public interface DnInfoService {
    void setDnInfo(dninfo dnInfo) throws Exception;
    //设置订单
    void  setOrderInfo(orderinfo orderInfo)throws Exception;
}

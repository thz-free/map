package com.example.map.dao;

import com.example.map.domain.dninfo;
import com.example.map.domain.orderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IDnInfoDao {
//   发布代拿事件
    void setDnInfo(dninfo dnInfo) throws Exception;
    //设置订单
    void  setOrderInfo(orderinfo orderInfo)throws Exception;
}

package com.example.map.dao;

import com.example.map.domain.TakeAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ITakeAddressDao {
    //存储收货地址信息
    void setTakeAddress(TakeAddress takeAddress) throws Exception;
    //获取收货地址信息
    List<TakeAddress> getTakeAddress() throws Exception;
    //更改收货地址信息
    void updateTakeAddress(TakeAddress takeAddress) throws Exception;
    //删除指定收货地址信息
    void deleteTakeAddress(Integer id)throws Exception;
}

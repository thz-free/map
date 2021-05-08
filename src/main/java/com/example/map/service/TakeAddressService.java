package com.example.map.service;

import com.example.map.domain.TakeAddress;

import java.util.List;

public interface TakeAddressService {
    void setTakeAddress(TakeAddress takeAddress) throws Exception;
    List<TakeAddress> getTakeAddress(Integer  userid) throws Exception;
    void updateTakeAddress(TakeAddress takeAddress) throws Exception;
    void deleteTakeAddress(Integer id) throws Exception;
    //查询地址
    TakeAddress findByOrderId(Integer id)throws Exception;
}

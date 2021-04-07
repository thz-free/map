package com.example.map.service;

import com.example.map.domain.TakeAddress;

import java.util.List;

public interface TakeAddressService {
    void setTakeAddress(TakeAddress takeAddress) throws Exception;
    List<TakeAddress> getTakeAddress() throws Exception;
    void updateTakeAddress(TakeAddress takeAddress) throws Exception;
    void deleteTakeAddress(Integer id) throws Exception;
}

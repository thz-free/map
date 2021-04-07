package com.example.map.service;

import com.example.map.domain.Userinfo;

import java.util.List;

public interface UserinfoService {
    void authorizeLogin(Userinfo userinfo)throws Exception;
    boolean isResgister(String wxphone)throws Exception;
}

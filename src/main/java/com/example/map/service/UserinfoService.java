package com.example.map.service;

import com.example.map.domain.Userinfo;

import java.util.List;

public interface UserinfoService {
    void setUserinfo(Userinfo userinfo)throws Exception;
    List<Userinfo> getUserinfo()throws Exception;
    void updateUserinfo(Userinfo userinfo)throws Exception;
}

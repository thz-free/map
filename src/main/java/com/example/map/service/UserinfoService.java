package com.example.map.service;

import com.example.map.domain.Userinfo;

import java.util.List;

public interface UserinfoService {
    void authorizeLogin(Userinfo userinfo)throws Exception;
    boolean isAuthorize(String openid)throws Exception;
    boolean isRegister(String openid)throws Exception;
    void setUserinfo(Userinfo userinfo)throws Exception;
    Userinfo getUserinfo(String openid) throws Exception;
}

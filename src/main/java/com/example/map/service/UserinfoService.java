package com.example.map.service;

import com.example.map.domain.Userinfo;

import java.util.List;

public interface UserinfoService {
    void authorizeLogin(Userinfo userinfo)throws Exception;
    boolean isAuthorize(String wxphone)throws Exception;
    boolean isRegister(String wxphone)throws Exception;
    void setUserinfo(Userinfo userinfo)throws Exception;
}

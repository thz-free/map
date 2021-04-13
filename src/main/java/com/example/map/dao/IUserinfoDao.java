package com.example.map.dao;

import com.example.map.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IUserinfoDao {
    //授权时存储数据
    void authorizeLogin(Userinfo userinfo) throws Exception;
    //判断是否授权
    Userinfo isAuthorize(String openid) throws Exception;
    //判断是否注册
    Integer isRegister(String openid) throws Exception;
    //保存用户信息
    void setUserinfo(Userinfo userinfo) throws Exception;
    //获取用户信息
    Userinfo getUserinfo(String openid) throws Exception;
}

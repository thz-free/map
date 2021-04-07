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
    //判断是否注册
    Userinfo isRegister(String wxphone) throws Exception;
}

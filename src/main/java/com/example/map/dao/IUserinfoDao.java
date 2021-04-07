package com.example.map.dao;

import com.example.map.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IUserinfoDao {
    //存储用户信息
    public void setUserinfo(Userinfo userinfo) throws Exception;
    //获取用户信息
    public List<Userinfo> getUserinfo() throws Exception;
    //更改用户信息
    public void updateUserinfo(Userinfo userinfo) throws Exception;
}

package com.example.map.service.serviceImpl;

import com.example.map.dao.IUserinfoDao;
import com.example.map.domain.Userinfo;
import com.example.map.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private IUserinfoDao iUserinfoDao;


    /**
     * 授权存储信息
     * @param userinfo
     * @throws Exception
     */
    @Override
    public void authorizeLogin(Userinfo userinfo) throws Exception {
        iUserinfoDao.authorizeLogin(userinfo);
        System.out.println("注册成功");
    }

    /**
     * 判断是否注册
     * @param wxphone
     * @return
     * @throws Exception
     */
    @Override
    public boolean isResgister(String wxphone) throws Exception {
        return iUserinfoDao.isRegister(wxphone) == null ? false : true;
    }
}

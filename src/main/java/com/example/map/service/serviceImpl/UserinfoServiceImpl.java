package com.example.map.service.serviceImpl;

import com.example.map.dao.IUserinfoDao;
import com.example.map.domain.Userinfo;
import com.example.map.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
     * 判断是否授权
     * @param openid
     * @return
     * @throws Exception
     */
    @Override
    public boolean isAuthorize(String openid) throws Exception {
        return iUserinfoDao.isAuthorize(openid) == null ? false : true;
    }

    /**
     * 判断是否注册
     * @param openid
     * @return
     * @throws Exception
     */
    @Override
    public boolean isRegister(String openid) throws Exception {
        System.out.println(iUserinfoDao.isRegister(openid));
        return iUserinfoDao.isRegister(openid) == 1 ? true : false;
    }

    /**
     * 保存用户信息
     * @param userinfo
     * @throws Exception
     */
    @Override
    public void setUserinfo(Userinfo userinfo) throws Exception {
        iUserinfoDao.setUserinfo(userinfo);
    }

    /**
     * 获取用户信息
     * @return
     * @throws Exception
     */
    @Override
    public Userinfo getUserinfo(String openid) throws Exception {
        return iUserinfoDao.getUserinfo(openid);
    }


}

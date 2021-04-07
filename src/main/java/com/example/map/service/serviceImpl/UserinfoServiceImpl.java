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
     * 存储用户信息
     * @param userinfo
     * @throws Exception
     */
    @Override
    public void setUserinfo(Userinfo userinfo) throws Exception {
        iUserinfoDao.setUserinfo(userinfo);
//        System.out.println(userinfo);
    }

    /**
     * 获取用户信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Userinfo> getUserinfo() throws Exception {
        List<Userinfo> userinfoList = iUserinfoDao.getUserinfo();
        return userinfoList;
    }

    /**
     * 更新用户数据
     * @param userinfo
     * @throws Exception
     */
    @Override
    public void updateUserinfo(Userinfo userinfo) throws Exception {
        iUserinfoDao.updateUserinfo(userinfo);
        System.out.println("修改成功");
    }


}

package com.example.map.service.serviceImpl;

import com.example.map.dao.IDbInfoDao;
import com.example.map.dao.IDginfoDao;
import com.example.map.domain.dbinfo;
import com.example.map.domain.orderinfo;
import com.example.map.service.DbInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-08 21:03
 */
@Service
@Transactional
public class DbInfoServiceImpl implements DbInfoService {
    @Autowired
    IDbInfoDao dbInfoDao;

    @Override
    public void setDbInfo(dbinfo dbInfo) throws Exception {
        System.out.println("111");
        System.out.println(dbInfo);
       dbInfoDao.setDbInfo(dbInfo);
    }

    @Override
    public void setOrderInfo(orderinfo orderInfo) throws Exception {
        dbInfoDao.setOrderInfo(orderInfo);
    }

    @Override
    public String findByIdDbaffairs(int id) throws Exception {
        return dbInfoDao.findByIdDbaffairs(id);
    }

    @Override
    public List<orderinfo> findByType(int type) throws Exception {
        return dbInfoDao.findByType(type);
    }
}

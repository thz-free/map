package com.example.map.service.serviceImpl;

import com.example.map.dao.IDbInfoDao;
import com.example.map.dao.IDginfoDao;
import com.example.map.domain.dbinfo;
import com.example.map.service.DbInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

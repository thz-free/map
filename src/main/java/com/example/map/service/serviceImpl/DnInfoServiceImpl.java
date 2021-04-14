package com.example.map.service.serviceImpl;

import com.example.map.dao.IDnInfoDao;
import com.example.map.domain.dninfo;
import com.example.map.domain.orderinfo;
import com.example.map.service.DnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-08 21:04
 */
@Service
@Transactional
public class DnInfoServiceImpl implements DnInfoService {
    @Autowired
    IDnInfoDao dnInfoDao;
    @Override
    public void setDnInfo(dninfo dnInfo) throws Exception {
       dnInfoDao.setDnInfo(dnInfo);
    }

    @Override
    public void setOrderInfo(orderinfo orderInfo) throws Exception {
        dnInfoDao.setOrderInfo(orderInfo);
    }
}

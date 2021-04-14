package com.example.map.service.serviceImpl;

import com.example.map.dao.IDginfoDao;
import com.example.map.dao.IDnInfoDao;
import com.example.map.domain.dginfo;
import com.example.map.domain.orderinfo;
import com.example.map.service.DgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-08 21:05
 */
@Service
@Transactional
public class DgInfoServiceImpl implements DgInfoService {
    @Autowired
    IDginfoDao dginfoDao;

    @Override
    public void setDgInfo(dginfo dgInfo) throws Exception {
      dginfoDao.setDgInfo(dgInfo);
    }

    @Override
    public void setOrderInfo(orderinfo orderInfo) throws Exception {
        dginfoDao.setOrderInfo(orderInfo);
    }
}

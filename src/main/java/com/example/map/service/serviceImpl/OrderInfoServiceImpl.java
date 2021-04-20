package com.example.map.service.serviceImpl;

import com.example.map.dao.IOrderInfoDao;
import com.example.map.domain.orderinfo;
import com.example.map.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-12 16:31
 */
@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private IOrderInfoDao iOrederInfoDao;

    @Override
    public void setOrderInfo(orderinfo orderInfo) {
        iOrederInfoDao.setOrderInfo(orderInfo);
    }

    @Override
    public orderinfo selectOrderInfo(Integer id) throws Exception {
        return iOrederInfoDao.selectOrderInfo(id);
    }

    @Override
    public List<orderinfo> selectAllOrder(Integer userid) throws Exception {
        System.out.println(userid);
        return iOrederInfoDao.selectAllOrder(userid);
    }

    @Override
    public void updateOrderState(orderinfo orderinfo) throws Exception {
        iOrederInfoDao.updateOrderState(orderinfo);
    }

    @Override
    public List<orderinfo> selectGrapOrder(Integer grapuser_id) throws Exception {
        return iOrederInfoDao.selectGrapOrder(grapuser_id);
    }
}

package com.example.map.service.serviceImpl;

import com.example.map.dao.ITakeAddressDao;
import com.example.map.domain.TakeAddress;
import com.example.map.service.TakeAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakeAddressServiceImpl implements TakeAddressService {
    @Autowired
    private ITakeAddressDao iTakeAddressDao;


    /**
     * 存储收货地址信息
     * @param takeAddress
     * @throws Exception
     */
    @Override
    public void setTakeAddress(TakeAddress takeAddress) throws Exception {
        iTakeAddressDao.setTakeAddress(takeAddress);
    }

    /**
     * 获取收货地址信息
     * @return
     * @throws Exception
     */
    @Override
    public List<TakeAddress> getTakeAddress(Integer  userid) throws Exception {
        return iTakeAddressDao.getTakeAddress(userid);
    }

    /**
     * 更改收货地址信息
     * @param takeAddress
     * @throws Exception
     */
    @Override
    public void updateTakeAddress(TakeAddress takeAddress) throws Exception {
        iTakeAddressDao.updateTakeAddress(takeAddress);
    }

    /**
     * 删除收货地址信息
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteTakeAddress(Integer id) throws Exception {
        iTakeAddressDao.deleteTakeAddress(id);
    }

    @Override
    public TakeAddress findByOrderId(Integer id) throws Exception {
         return iTakeAddressDao.findByOrderId(id);
    }


}

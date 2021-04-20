package com.example.map.controller;

import com.example.map.domain.GrapOder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerTest {

    /**
     * 展示所有订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String selectAllOrder(){
        return null;
    }

    /**
     * 查询此时正在抢单的信息
     * @param id
     * @return
     */
    public GrapOder selectGrapOrderNow(Integer id){
        return null;
    }
}

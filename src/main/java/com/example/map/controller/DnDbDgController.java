package com.example.map.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.map.domain.dbinfo;
import com.example.map.domain.dginfo;
import com.example.map.domain.dninfo;
import com.example.map.domain.orderinfo;
import com.example.map.service.DbInfoService;
import com.example.map.service.DgInfoService;
import com.example.map.service.DnInfoService;
import com.example.map.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-08 21:11
 */
@RestController
@Slf4j
public class DnDbDgController {
    @Autowired
    private DbInfoService dbInfoService;
    @Autowired
    private DgInfoService dgInfoService;
    @Autowired
    private DnInfoService dnInfoService;
    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = {"/setDbInfo"},method =RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setDbInfoController(@RequestBody(required = false) dbinfo dbinfo1) throws Exception {
        JSONObject result = new JSONObject();
        dbInfoService.setDbInfo(dbinfo1);
        //生成代办订单
        orderinfo orderinfo1=new orderinfo();
        orderinfo1.setType(0);
        orderinfo1.setState(false);
        orderinfo1.setTitle(dbinfo1.getDbaffairs());
        orderinfo1.setUser_id(dbinfo1.getUser_id());
        orderinfo1.setMoney(dbinfo1.getMoney());
        String content = dbinfo1.getDbtime()+"去"+dbinfo1.getDbaddress()+dbinfo1.getDbaffairs();
        orderinfo1.setContent(content);
        dbInfoService.setOrderInfo(orderinfo1);
        System.out.println("xinxi:"+dbinfo1);
        result.put("message","代办订单发布成功");
        log.info(result.toJSONString());
        return result.toJSONString();
    }

    @RequestMapping(value = {"/setDgInfo"},method =RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setDgInfoController(@RequestBody(required = false) dginfo dginfo1) throws Exception {
        JSONObject result = new JSONObject();
        dgInfoService.setDgInfo(dginfo1);
        //生成代购订单
        orderinfo orderinfo1=new orderinfo();
        orderinfo1.setType(1);
        orderinfo1.setState(false);
        orderinfo1.setTitle(dginfo1.getBuyThings());
        orderinfo1.setUser_id(dginfo1.getUser_id());
        orderinfo1.setMoney(dginfo1.getMoney());
        String content = dginfo1.getBuyaddress()+"购买"+dginfo1.getBuyThings()+"送到"+dginfo1.getDeliveryaddress();
        orderinfo1.setContent(content);
        dbInfoService.setOrderInfo(orderinfo1);
        result.put("message","代购订单发布成功");
        log.info(result.toJSONString());
        return result.toJSONString();
    }
    @RequestMapping(value = {"/setDnInfo"},method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String setDnInfoController(@RequestBody(required = false) dninfo dninfo1) throws Exception {
        JSONObject result=new JSONObject();
        dnInfoService.setDnInfo(dninfo1);
        //生成代拿订单
        orderinfo orderinfo1=new orderinfo();
        orderinfo1.setType(2);
        orderinfo1.setState(false);
        orderinfo1.setTitle(dninfo1.getDeliveryaddress());
        orderinfo1.setUser_id(dninfo1.getUser_id());
        orderinfo1.setMoney(dninfo1.getMoney());
        orderinfo1.setDnNumber(dninfo1.getDnNumber());
        String content = "去"+dninfo1.getKdAddress()+"拿快递送达"+dninfo1.getDeliveryaddress();
        orderinfo1.setContent(content);
        dbInfoService.setOrderInfo2(orderinfo1);
        result.put("message","代拿订单发布成功");
        log.info(result.toJSONString());
        return result.toJSONString();
    }
//查询订单
    @GetMapping("/findByType")
    public List<orderinfo> findByType(int type) throws Exception {
        System.out.println(type);
        System.out.println(dbInfoService.findByType(type));
        return dbInfoService.findByType(type);
    }

    //查询此时被抢订单
    public orderinfo findById(int id) throws Exception{
        orderinfo orderinfo = orderInfoService.selectOrderInfo(id);
        return orderinfo;
    }

    //查询用户所有订单
    @RequestMapping(value = "/selectAllOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String selectAllOrder(@RequestBody JSONObject jsonParam){
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonParam.get("userid"));
        try {
            List<orderinfo> list = orderInfoService.selectAllOrder((Integer)jsonParam.get("userid"));
            jsonObject.put("orders",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }
}

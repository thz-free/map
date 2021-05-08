package com.example.map.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.map.domain.TakeAddress;
import com.example.map.domain.Userinfo;
import com.example.map.domain.dbinfo;
import com.example.map.service.TakeAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TakeAddressController {

    @Autowired
    private TakeAddressService takeAddressService;

    /**
     * 存储收货地址信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setTakeAddress",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setTakeAddress(@RequestBody(required = false) TakeAddress takeAddress){
        TakeAddress takeAddress1 = takeAddress;
        JSONObject result = new JSONObject();
        System.out.println(takeAddress);

        try {
            takeAddressService.setTakeAddress(takeAddress1);
            result.put("msg", "ok");
            result.put("method", "request");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取收货地址信息
     * @return
     */
    @RequestMapping(value = "/getTakeAddress",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject getTakeAddress(@RequestBody JSONObject jsonParam){
        JSONObject jsonObject = new JSONObject();
        try {
            List<TakeAddress> takeAddressList = takeAddressService.getTakeAddress((Integer) jsonParam.get("userid"));
            jsonObject.put("takeAddressList",takeAddressList);
            System.out.println(takeAddressList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 更改获取地址信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateTakeAddress",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateTakeAddress(@RequestBody(required = false) TakeAddress takeAddress) {
        TakeAddress takeAddress1 = takeAddress;
        JSONObject result = new JSONObject();

        try {
            takeAddressService.updateTakeAddress(takeAddress1);
            result.put("msg", "ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.put("method", "request");
        return result.toJSONString();
    }

    /**
     * 删除指定id地址信息
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteTakeAddress",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String deleteTakeAddress(@RequestBody JSONObject jsonParam){
//        System.out.println("删除地址id："+jsonParam.toJSONString());
        JSONObject result = new JSONObject();

        try {
            takeAddressService.deleteTakeAddress((Integer) jsonParam.get("id"));
            result.put("msg", "ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.put("method", "request");
        return result.toJSONString();
    }
    @ResponseBody
    @RequestMapping(value ="/findByid",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public TakeAddress findById(Integer id) throws Exception {

        return takeAddressService.findByOrderId(id);
    }
}

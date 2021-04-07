package com.example.map.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.map.domain.TakeAddress;
import com.example.map.domain.Userinfo;
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
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setTakeAddress",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setTakeAddress(@RequestBody JSONObject jsonParam){
        System.out.println("收货地址数据："+jsonParam.toJSONString());
        TakeAddress takeAddress = new TakeAddress();
        JSONObject result = new JSONObject();

        takeAddress.setAddress(jsonParam.getString("address"));
        takeAddress.setSex(jsonParam.getString("sex"));
        takeAddress.setPhone(jsonParam.getString("tel"));
        takeAddress.setLocation(jsonParam.getString("location"));
        takeAddress.setUsername(jsonParam.getString("username"));

        try {
            takeAddressService.setTakeAddress(takeAddress);
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
    public JSONObject getUserinfo(){
        JSONObject jsonObject = new JSONObject();
        try {
            List<TakeAddress> takeAddressList = takeAddressService.getTakeAddress();
            jsonObject.put("takeAddressList",takeAddressList);
            System.out.println(takeAddressList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 更改获取地址信息
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateTakeAddress",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateTakeAddress(@RequestBody JSONObject jsonParam){
//        System.out.println("更改地址数据："+jsonParam.toJSONString());
        TakeAddress takeAddress = new TakeAddress();
        JSONObject result = new JSONObject();

        takeAddress.setUsername(jsonParam.getString("username"));
        takeAddress.setLocation(jsonParam.getString("location"));
        takeAddress.setPhone(jsonParam.getString("phone"));
        takeAddress.setSex(jsonParam.getString("sex"));
        takeAddress.setAddress(jsonParam.getString("address"));
        takeAddress.setId((Integer)jsonParam.get("id"));

        try {
            takeAddressService.updateTakeAddress(takeAddress);
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

}

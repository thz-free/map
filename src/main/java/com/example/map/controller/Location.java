package com.example.map.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class Location {
    @ResponseBody
    @RequestMapping(value = "/setLocaltion",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setLocation(@RequestBody JSONObject jsonParam){

        System.out.println(jsonParam.toJSONString());
        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "request");
        result.put("data", "latitude: 30.22, longitude: 40.11");
        return result.toJSONString();
    }
}

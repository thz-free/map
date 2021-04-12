package com.example.map.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.map.domain.dbinfo;
import com.example.map.domain.dginfo;
import com.example.map.domain.dninfo;
import com.example.map.service.DbInfoService;
import com.example.map.service.DgInfoService;
import com.example.map.service.DnInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = {"/setDbInfo"},method =RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setDbInfoController(@RequestBody(required = false) dbinfo dbinfo1) throws Exception {
        JSONObject result = new JSONObject();
        dbInfoService.setDbInfo(dbinfo1);
        System.out.println("xinxi:"+dbinfo1);
        result.put("message","代办订单发布成功");
        log.info(result.toJSONString());
        return result.toJSONString();
    }

    @RequestMapping(value = {"/setDgInfo"},method =RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setDgInfoController(@RequestBody(required = false) dginfo dginfo1) throws Exception {
        JSONObject result = new JSONObject();
        dgInfoService.setDgInfo(dginfo1);
        result.put("message","代购订单发布成功");
        log.info(result.toJSONString());
        return result.toJSONString();
    }
    @RequestMapping(value = {"/setDnInfo"},method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String setDnInfoController(@RequestBody(required = false) dninfo dninfo1) throws Exception {
        JSONObject result=new JSONObject();
        dnInfoService.setDnInfo(dninfo1);
        result.put("message","代拿订单发布成功");
        log.info(result.toJSONString());
        return result.toJSONString();
    }
}
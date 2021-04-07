package com.example.map.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.map.domain.Userinfo;
import com.example.map.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    /**
     * 存储用户信息
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setUserinfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setUserinfo(@RequestBody JSONObject jsonParam){

//        System.out.println("用户信息："+jsonParam.toJSONString());
//        System.out.println("username:"+jsonParam.get("username"));
        JSONObject result = new JSONObject();
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername(jsonParam.getString("username"));
        userinfo.setIsDainaString(jsonParam.getString("isDaina"));
        userinfo.setStudentCode(jsonParam.getString("studentCode"));
        userinfo.setUserphone(jsonParam.getString("userphone"));
        try {
            userinfoService.setUserinfo(userinfo);
        } catch (Exception e) {
            result.put("msg","exist");
            result.put("method", "request");
            System.out.println(e.getMessage());
            System.out.println("用户已存在！");
            return result.toJSONString();
        }

        // 将获取的json数据封装一层，然后在给返回
        result.put("msg", "ok");
        result.put("method", "request");
        return result.toJSONString();
    }

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "/getUserinfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject getUserinfo(){
        JSONObject jsonObject = new JSONObject();
        try {
            List<Userinfo> userinfoList = userinfoService.getUserinfo();
            jsonObject.put("userinfoList",userinfoList);
//            System.out.println(userinfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 更改用户信息
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserinfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateUserinfo(@RequestBody JSONObject jsonParam){
        Userinfo userinfo = new Userinfo();
        JSONObject result = new JSONObject();
//        System.out.println("用户信息："+jsonParam.toJSONString());
        userinfo.setUsername(jsonParam.getString("username"));
        userinfo.setIsDainaString(jsonParam.getString("isDaina"));
        userinfo.setStudentCode(jsonParam.getString("studentCode"));
        userinfo.setUserphone(jsonParam.getString("userphone"));
        userinfo.setId((Integer) jsonParam.get("id"));
//        System.out.println(userinfo);
        try {
            userinfoService.updateUserinfo(userinfo);
            result.put("msg", "ok");
        }catch (Exception e) {
            result.put("msg", "fail");
            e.printStackTrace();
        }
        result.put("method", "request");
        return result.toJSONString();
    }
}

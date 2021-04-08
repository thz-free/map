package com.example.map.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.map.domain.Userinfo;
import com.example.map.service.UserinfoService;
import com.example.map.utils.WXCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    /**
     * 获取sessionKey
     * @param code
     * @return
     */
    public String getSessionKey(String appid,String secret,String code){
        String sessionKey = null;
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
            RestTemplate restTemplate = new RestTemplate();
            String forObject = restTemplate.getForObject(url, String.class);
            JSONObject jsonObject = JSONObject.parseObject(forObject);  //字符串转成json
            System.out.println(jsonObject.getString("session_key"));
            System.out.println(jsonObject);
            sessionKey = jsonObject.getString("session_key");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionKey;
    }

    /**
     * 授权操作,存入数据
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/authorizeLogin",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String authorizeLogin(@RequestBody JSONObject jsonObject){
        //appid,encryptedData,code,secret(sessionKey),iv
        //存入的值：wxphone,isregister,grabcounts,putcounts,isdaina
        //System.out.println(jsonObject.toJSONString());
        String appid = jsonObject.getString("appid");
        String encryptedData = jsonObject.getString("encryptedData");
        String code = jsonObject.getString("code");
        String secret = jsonObject.getString("secret");
        String iv = jsonObject.getString("iv");

        JSONObject resultJson = new JSONObject();

        //1.获取sessionKey
        String sessionKey = getSessionKey(appid,secret,code);
        //2.获取手机号
        //解密获取结果
        try {
            String result = WXCore.decrypt(appid,encryptedData,sessionKey,iv);
            JSONObject parseObject = JSONObject.parseObject(result);
            //System.out.println(parseObject);
            //防止空指针异常
            if(parseObject!=null) {
                //获取的该手机号并不一定为非空，所以后面需要判断phone是否为null或者""
                String wxphone = parseObject.getString("phoneNumber");
                //System.out.println(wxphone);
                if(userinfoService.isAuthorize(wxphone)) {
                    resultJson.put("msg", "ok");
                } else {
                    userinfoService.authorizeLogin(new Userinfo(wxphone, 0, 0, 0, 0));
                    resultJson.put("msg", "ok");
                }
                resultJson.put("wxphone",wxphone);
            }else {
                resultJson.put("msg", "fail");
                return null;
            }
        }catch (Exception e){
            resultJson.put("msg", "fail");
            e.printStackTrace();
        }
        return resultJson.toJSONString();
    }

    /**
     * 是否注册
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/isRegister",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String isRegister(@RequestBody JSONObject jsonObject){
        String wxphone = jsonObject.getString("wxphone");
        //System.out.println("phone"+wxphone);
        JSONObject result = new JSONObject();
        try {
           //判断是否注册
            if(userinfoService.isRegister(wxphone)){
                result.put("isregister",true);
            }else {
                result.put("isregister",false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 保存用户信息
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setUserinfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String setUserinfo(@RequestBody JSONObject jsonObject){
        JSONObject result = new JSONObject();
        try {
            int isdaina = jsonObject.getString("isDaina").equals("false") ? 0 : 1;
            userinfoService.setUserinfo(new Userinfo(jsonObject.getString("username"),jsonObject.getString("studentCode"),1,jsonObject.getString("userphone"),isdaina,jsonObject.getString("wxphone")));
            result.put("msg","ok");
            System.out.println("用户信息保存成功！");
        } catch (Exception e) {
            result.put("msg","fail");
            System.out.println("用户信息保存失败！");
            e.printStackTrace();
        }
        System.out.println(jsonObject.toJSONString());
        return result.toJSONString();
    }

    /**
     * 获取用户基本信息
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserinfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getUserinfo(@RequestBody JSONObject jsonObject){
        JSONObject result = new JSONObject();
        try {
            result.put("userinfo",userinfoService.getUserinfo(jsonObject.getString("wxphone")));
            result.put("msg","ok");
        } catch (Exception e) {
            result.put("msg","fail");
            e.printStackTrace();
        }
        return result.toJSONString();
    }
    
}

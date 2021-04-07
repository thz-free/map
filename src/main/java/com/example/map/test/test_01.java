package com.example.map.test;

import com.alibaba.fastjson.JSONObject;
import com.example.map.utils.WXCore;

public class test_01 {
    public static void main(String[] args) {
        String appid = "wxe5aec76fc17b9daa";
        String encryptedData = "yBCxwVkoKjYCl92nXIw4pQGCMFUTIX0I+rB1YYXcQKiCDjv8ed5JsUDeO6xES4iz6j7rGEDUaLDuaHGqlXMuxP/CJxT98iG9gduhPQUGOiMTvjOkJR1xyRjCK8NBJRY6sDW8vbF6zWMTlT1L/fm1jsl0UXPZw0KW9Xpsctaoe/oc1w1QVzFXnY3wFjwl3wTUf79wpZa4gsRqpgoRLyxxGg==";
        String sessionKey = "s3HhyBLXSeC49vRkxgVmSw==";
        String iv = "hC+8fl29fdm1Wo2Ob5R0UQ==";
        //解密获取结果
        String result = WXCore.decrypt(appid,encryptedData,sessionKey,iv);
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject);
        //防止空指针异常
        if(jsonObject!=null) {
            //获取的该手机号并不一定为非空，所以后面需要判断phone是否为null或者""
            String phone = jsonObject.getString("phoneNumber");
            System.out.println(phone);
        }
    }
}

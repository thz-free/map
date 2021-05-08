package com.example.map.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.map.domain.orderinfo;
import com.example.map.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;

@RestController
public class GrapOrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 订单状态
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/orderState",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String OrderState(@RequestBody JSONObject jsonObject){
        JSONObject result = new JSONObject();
        Integer id =  Integer.parseInt(jsonObject.getString("id"));
        try {
            result.put("state",orderInfoService.selectOrderInfo(id).getState());
            result.put("content",orderInfoService.selectOrderInfo(id).getContent());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toJSONString();
    }
    /**
     * 抢单操作
     * @param jsonObject
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/grapOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String GrapOrder(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        try {
            JSONObject result = new JSONObject();
            Integer id = Integer.parseInt(jsonObject.getString("id"));
            Integer grapuser_id = (Integer) jsonObject.get("grapUserid");
            orderinfo orderinfo = orderInfoService.selectOrderInfo(id);
            synchronized (orderinfo){
                //1.如果此时的订单状态为1，则结束并返回数据提醒用户抢单失败,请用户刷新页面或检查网络
                if(orderinfo.getState()){
                    result.put("result","fail");
                    return result.toJSONString();
                }else {
                    //2.如果此时的订单状态为0，则将此时的状态变成1并将此订单的抢单者的id即grapUserid修改进去，最后结束提醒用户抢单成功,并提醒发布者订单被抢，并开始计时
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    long time = sdf.parse(sdf.format(new Date())).getTime();
                    System.out.println(time);
                    orderInfoService.updateOrderState(new orderinfo(id,true,grapuser_id,time));
                    result.put("result","success");
                    return result.toJSONString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取消订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelGrapOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String CancelGrapOrder(@RequestBody JSONObject jsonObject){
        //1.如果时间超过多少，则无法取消
        //2.在时间范围内，则将订单的状态变为0，并将抢单者的userid删除，并提醒抢单者已取消和发布者订单已被取消
        try {
            JSONObject result = new JSONObject();
            Integer id = Integer.parseInt(jsonObject.getString("id"));
            Integer grapuser_id = (Integer) jsonObject.get("grapUserid");
            orderinfo orderinfo = orderInfoService.selectOrderInfo(id);
            synchronized (orderinfo){
                SimpleDateFormat sdf = new SimpleDateFormat();
                long time = orderinfo.getTime();
                long nowTime = sdf.parse(sdf.format(new Date())).getTime();
                long period = nowTime - time;
                System.out.println(period);
                if(orderinfo.getState() && period <= 300000){   //小于5分钟
                    result.put("result","success");
                    orderInfoService.updateOrderState(new orderinfo(id,false,null,null));
                    return result.toJSONString();
                }else {
                    result.put("result","fail");
                    if(period > 300000){
                        result.put("time","over");
                    }
                    return result.toJSONString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/searchGrapOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String SearchGrapOrder(@RequestBody JSONObject jsonObject){
        JSONObject result = new JSONObject();
        //通过抢单者的userid来查询抢单列表
        try {
            List<orderinfo> list = orderInfoService.selectGrapOrder((Integer) jsonObject.get("grapuser_id"));
            result.put("graporders",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toJSONString();
    }
}

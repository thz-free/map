package com.example.map.controller;

import com.example.map.domain.GrapOder;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.Lock;

@RestController
public class GrapOrderController {

    /**
     * 抢单操作
     * @param grapOder
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/grapOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String GrapOrder(@RequestBody(required = false)GrapOder  grapOder) {
        System.out.println(grapOder);
        Object o = new Object();
        Lock lock = (Lock) o;//lock为此时被抢的订单
        synchronized (lock){
            //1.如果此时的订单状态为1，则结束并返回数据提醒用户抢单失败,请用户刷新页面或检查网络
            //2.如果此时的订单状态为0，则将此时的状态变成1并将此订单的抢单者的id即grapUserid修改进去，最后结束提醒用户抢单成功,并提醒发布者订单被抢，并开始计时
        }
        return null;
    }

    /**
     * 取消订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelGrapOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String CancelGrapOrder(){
        //1.如果时间超过多少，则无法取消
        //2.在时间范围内，则将订单的状态变为0，并将抢单者的userid删除，并提醒抢单者已取消和发布者订单已被取消
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/searchGrapOrder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String SearchGrapOrder(){
        //通过抢单者的userid来查询抢单列表
        return null;
    }
}

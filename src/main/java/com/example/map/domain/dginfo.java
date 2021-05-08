package com.example.map.domain;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-07 21:03
 */

import java.io.Serializable;
import java.util.Objects;

/**
 * 代购
 */
public class dginfo implements Serializable {
    private int id;
    private String buyThings;
    private String buyaddress;
    private String deliveryaddress;
    private int user_id;
    private int money;

    @Override
    public String toString() {
        return "dginfo{" +
                "id=" + id +
                ", buyThings='" + buyThings + '\'' +
                ", buyaddress='" + buyaddress + '\'' +
                ", deliveryaddress='" + deliveryaddress + '\'' +
                ", user_id=" + user_id +
                ", money=" + money +
                '}';
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyThings() {
        return buyThings;
    }

    public void setBuyThings(String buyThings) {
        this.buyThings = buyThings;
    }

    public String getBuyaddress() {
        return buyaddress;
    }

    public void setBuyaddress(String buyaddress) {
        this.buyaddress = buyaddress;
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

package com.example.map.domain;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-07 21:10
 */

import java.io.Serializable;
import java.util.Objects;

/**
 * 代拿
 */
public class dninfo implements Serializable {
    private int id;
    private String kdAddress;
    private String deliveryaddress;
    private int user_id;
    private int money;
    private String dnNumber;

    @Override
    public String toString() {
        return "dninfo{" +
                "id=" + id + '\'' +
                ", kdAddress='" + kdAddress + '\'' +
                ", deliveryaddress='" + deliveryaddress + '\'' +
                ", user_id=" + user_id +
                ", money=" + money +
                ", dnNumber='" + dnNumber + '\'' +
                '}';
    }

    public String getDnNumber() {
        return dnNumber;
    }

    public void setDnNumber(String dnNumber) {
        this.dnNumber = dnNumber;
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

    public String getKdAddress() {
        return kdAddress;
    }

    public void setKdAddress(String kdAddress) {
        this.kdAddress = kdAddress;
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

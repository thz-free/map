package com.example.map.domain;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-07 21:01
 */

import java.io.Serializable;
import java.util.Objects;

/**
 * 代办信息
 */
public class dbinfo implements Serializable {
    private int id;
    private String dbaffairs;
    private String dbaddress;
    private String dbtime;
    private int user_id;
    private int money;


    @Override
    public String toString() {
        return "dbinfo{" +
                "id=" + id +
                ", dbaffairs='" + dbaffairs + '\'' +
                ", dbaddress='" + dbaddress + '\'' +
                ", dbtime='" + dbtime + '\'' +
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

    public String getDbaffairs() {
        return dbaffairs;
    }

    public void setDbaffairs(String dbaffairs) {
        this.dbaffairs = dbaffairs;
    }

    public String getDbaddress() {
        return dbaddress;
    }

    public void setDbaddress(String dbaddress) {
        this.dbaddress = dbaddress;
    }

    public String getDbtime() {
        return dbtime;
    }

    public void setDbtime(String dbtime) {
        this.dbtime = dbtime;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

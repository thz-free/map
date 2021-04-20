package com.example.map.domain;

/**
 * @program: map
 * @description:
 * @author: liu yan
 * @create: 2021-04-12 16:21
 */

import java.io.Serializable;

/**
 * 订单表
 */
public class orderinfo implements Serializable {
    private int id;
    private int type;
    private String title;
    private Boolean state;
    private int user_id;
    private int addressinfo_id;
    private Integer grapuser_id;
    private Long time;
    private String content;

    public orderinfo(){}

    public orderinfo(int id, Boolean state, Integer grapuser_id,Long time) {
        this.id = id;
        this.state = state;
        this.grapuser_id = grapuser_id;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAddressinfo_id() {
        return addressinfo_id;
    }

    public void setAddressinfo_id(int addressinfo_id) {
        this.addressinfo_id = addressinfo_id;
    }

    public Integer getGrapuser_id() {
        return grapuser_id;
    }

    public void setGrapuser_id(Integer grapuser_id) {
        this.grapuser_id = grapuser_id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "orderinfo{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", state=" + state +
                ", user_id=" + user_id +
                ", addressinfo_id=" + addressinfo_id +
                ", grapuser_id=" + grapuser_id +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
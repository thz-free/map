package com.example.map.domain;

import java.util.Date;

public class OrderTest {
    private Integer id;
    private Integer type;
    private String title;
    private Integer state;
    private Integer user_id;
    private Integer addressinfo_id;
    private Integer grapuser_id;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAddressinfo_id() {
        return addressinfo_id;
    }

    public void setAddressinfo_id(Integer addressinfo_id) {
        this.addressinfo_id = addressinfo_id;
    }

    public Integer getGrapuser_id() {
        return grapuser_id;
    }

    public void setGrapuser_id(Integer grapuser_id) {
        this.grapuser_id = grapuser_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OrderTest{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", state=" + state +
                ", user_id=" + user_id +
                ", addressinfo_id=" + addressinfo_id +
                ", grapuser_id=" + grapuser_id +
                ", time=" + time +
                '}';
    }
}

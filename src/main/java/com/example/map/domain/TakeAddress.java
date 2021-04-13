package com.example.map.domain;

public class TakeAddress {
    private Integer id;
    private String address;
    private String sex;
    private String phone;
    private String location;
    private String username;
    private String userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "TakeAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", username='" + username + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}

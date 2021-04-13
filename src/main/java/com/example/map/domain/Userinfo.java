package com.example.map.domain;

public class Userinfo {
    private Integer userid;
    private String openid;
    private String username;
    private String studentCode;
    private Integer isregister;  //1为注册
    private String userphone;
    private Integer isdaina; // 1为代拿
    private Integer grabcounts;
    private Integer putcounts;

    public Userinfo(){};
    public Userinfo(String openid, Integer isregister, Integer isdaina, Integer grabcounts, Integer putcounts) {
        this.openid = openid;
        this.isregister = isregister;
        this.isdaina = isdaina;
        this.grabcounts = grabcounts;
        this.putcounts = putcounts;
    }

    public Userinfo(String username, String studentCode, Integer isregister, String userphone, Integer isdaina,String openid) {
        this.username = username;
        this.studentCode = studentCode;
        this.isregister = isregister;
        this.userphone = userphone;
        this.isdaina = isdaina;
        this.openid = openid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getWxphone() {
        return openid;
    }

    public void setWxphone(String wxphone) {
        this.openid = wxphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Integer getIsregister() {
        return isregister;
    }

    public void setIsregister(Integer isregister) {
        this.isregister = isregister;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Integer getIsdaina() {
        return isdaina;
    }

    public void setIsdaina(Integer isdaina) {
        this.isdaina = isdaina;
    }

    public Integer getGrabcounts() {
        return grabcounts;
    }

    public void setGrabcounts(Integer grabcounts) {
        this.grabcounts = grabcounts;
    }

    public Integer getPutcounts() {
        return putcounts;
    }

    public void setPutcounts(Integer putcounts) {
        this.putcounts = putcounts;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "userid=" + userid +
                ", openid='" + openid + '\'' +
                ", username='" + username + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", isregister=" + isregister +
                ", userphone='" + userphone + '\'' +
                ", isdaina=" + isdaina +
                ", grabcounts=" + grabcounts +
                ", putcounts=" + putcounts +
                '}';
    }
}

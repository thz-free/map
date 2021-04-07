package com.example.map.domain;

public class Userinfo {
    private String username;
    private String studentCode;
    private String userphone;
    private Boolean isDaina;
    private String isDainaString;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Boolean getDaina() {
        if (isDaina == true){
            isDainaString = "true";
        }else {
            isDainaString = "false";
        }
        return isDaina;
    }

    public void setDaina(Boolean daina) {
            this.isDaina = daina;
    }

    public String getIsDainaString() {
        return isDainaString;
    }

    public void setIsDainaString(String isDainaString) {
        if (isDainaString.equals("true")){
            this.isDaina = true;
        }else {
            this.isDaina = false;
        }
        this.isDainaString = isDainaString;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "username='" + username + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", userphone='" + userphone + '\'' +
                ", isDaina=" + isDaina +
                ", isDainaString='" + isDainaString + '\'' +
                ", id=" + id +
                '}';
    }
}

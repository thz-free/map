package com.example.map.domain;

public class GrapOder {
    private Integer id;
    private Integer type;
    private Integer state;
    private Integer userid;
    private Integer grapUserid;

    public GrapOder(Integer id, Integer type, Integer state, Integer userid, Integer grapUserid) {
        this.id = id;
        this.type = type;
        this.state = state;
        this.userid = userid;
        this.grapUserid = grapUserid;
    }

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGrapUserid() {
        return grapUserid;
    }

    public void setGrapUserid(Integer grapUserid) {
        this.grapUserid = grapUserid;
    }

    @Override
    public String toString() {
        return "GrapOder{" +
                "id=" + id +
                ", type=" + type +
                ", state=" + state +
                ", userid=" + userid +
                ", grapUserid=" + grapUserid +
                '}';
    }
}

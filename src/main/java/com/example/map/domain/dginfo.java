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
    private int dginfo_id;

    @Override
    public String toString() {
        return "dginfo{" +
                "id=" + id +
                ", buyThings='" + buyThings + '\'' +
                ", buyaddress='" + buyaddress + '\'' +
                ", deliveryaddress='" + deliveryaddress + '\'' +
                ", dginfo_id=" + dginfo_id +
                '}';
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dginfo dginfo = (dginfo) o;
        return id == dginfo.id &&
                dginfo_id == dginfo.dginfo_id &&
                Objects.equals(buyThings, dginfo.buyThings) &&
                Objects.equals(buyaddress, dginfo.buyaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyThings, buyaddress, dginfo_id);
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

    public int getDginfo_id() {
        return dginfo_id;
    }

    public void setDginfo_id(int dginfo_id) {
        this.dginfo_id = dginfo_id;
    }
}

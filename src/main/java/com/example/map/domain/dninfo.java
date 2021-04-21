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
    private String image;
    private String kdAddress;
    private String deliveryaddress;
    private int user_id;

    @Override
    public String toString() {
        return "dninfo{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", kdAddress='" + kdAddress + '\'' +
                ", deliveryaddress='" + deliveryaddress + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

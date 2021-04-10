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
    private int dninfo_id;

    @Override
    public String toString() {
        return "dninfo{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", kdAddress='" + kdAddress + '\'' +
                ", deliveryaddress='" + deliveryaddress + '\'' +
                ", dninfo_id=" + dninfo_id +
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
        dninfo dninfo = (dninfo) o;
        return id == dninfo.id &&
                dninfo_id == dninfo.dninfo_id &&
                Objects.equals(image, dninfo.image) &&
                Objects.equals(kdAddress, dninfo.kdAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, kdAddress, dninfo_id);
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

    public int getDninfo_id() {
        return dninfo_id;
    }

    public void setDninfo_id(int dninfo_id) {
        this.dninfo_id = dninfo_id;
    }
}

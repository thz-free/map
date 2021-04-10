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
    private int dbinfo_id;

    @Override
    public String toString() {
        return "dbinfo{" +
                "id=" + id +
                ", dbaffairs='" + dbaffairs + '\'' +
                ", dbaddress='" + dbaddress + '\'' +
                ", dbtime='" + dbtime + '\'' +
                ", dbinfo_id=" + dbinfo_id +
                '}';
    }

    public int getDbinfo_id() {
        return dbinfo_id;
    }

    public void setDbinfo_id(int dbinfo_id) {
        this.dbinfo_id = dbinfo_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbinfo dbinfo = (dbinfo) o;
        return id == dbinfo.id &&
                Objects.equals(dbaffairs, dbinfo.dbaffairs) &&
                Objects.equals(dbaddress, dbinfo.dbaddress) &&
                Objects.equals(dbtime, dbinfo.dbtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dbaffairs, dbaddress, dbtime);
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
}

package com.cxj.wash_car.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxj
 * @since 2024-11-08
 */
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String number;

    private Integer uid;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id = " + id +
            ", number = " + number +
            ", uid = " + uid +
            ", status = " + status +
        "}";
    }
}

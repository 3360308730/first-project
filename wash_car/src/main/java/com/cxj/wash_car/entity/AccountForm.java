package com.cxj.wash_car.entity;

import lombok.Data;

@Data
public class AccountForm {
    private String loginname;
    private String password;
    private String code;
    private Integer type;
}

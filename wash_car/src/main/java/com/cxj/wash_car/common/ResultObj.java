package com.cxj.wash_car.common;

import com.cxj.wash_car.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultObj {

    public static final ResultObj LOGIN_ERROR_NAME = new ResultObj(-1,"用户名或类型错误");
    public static final ResultObj LOGIN_ERROR_PASSWORD = new ResultObj(-1,"用户密码错误");
    public static final ResultObj LOGIN_ERROR_CODE = new ResultObj(-1,"验证码错误");

    public ResultObj(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;
    private Object user;
}

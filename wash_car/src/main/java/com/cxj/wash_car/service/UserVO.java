package com.cxj.wash_car.service;

import com.cxj.wash_car.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO extends User {
    private String carNumber;
}

package com.cxj.wash_car.vo;

import com.cxj.wash_car.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CarVO extends Car {
    private String username;
}

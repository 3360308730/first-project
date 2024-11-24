package com.cxj.wash_car.service.impl;

import com.cxj.wash_car.entity.Car;
import com.cxj.wash_car.mapper.CarMapper;
import com.cxj.wash_car.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxj
 * @since 2024-11-08
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

}

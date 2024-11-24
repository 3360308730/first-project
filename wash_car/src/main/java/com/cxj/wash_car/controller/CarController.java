package com.cxj.wash_car.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxj.wash_car.common.PageModel;
import com.cxj.wash_car.entity.Car;
import com.cxj.wash_car.service.ICarService;
import com.cxj.wash_car.service.IUserService;
import com.cxj.wash_car.vo.CarVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxj
 * @since 2024-11-08
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private ICarService iCarService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public Map list(PageModel pageModel){
            Page<Car> page = new Page<>(pageModel.getPage(), pageModel.getLimit());
            Page<Car> resultPage = this.iCarService.page(page);
            Map map = new HashMap<>();
            List<CarVO> list = new ArrayList<>();
            for(Car record : resultPage.getRecords()){
                CarVO carVO = new CarVO();
                BeanUtils.copyProperties(record,carVO);
                carVO.setUsername(this.iUserService.getById(record.getUid()).getUsername());
                list.add(carVO);
            }
            map.put("data",list);
            map.put("count",resultPage.getTotal());
            return map;
    }
}

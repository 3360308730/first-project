package com.cxj.wash_car.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxj.wash_car.entity.Menu;
import com.cxj.wash_car.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxj
 * @since 2024-10-29
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    @GetMapping("/leftmenu/{type}")
    public List<Menu> leftmenu(@PathVariable("type") Integer type){
        QueryWrapper <Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",type);
        List<Menu> menu = this.iMenuService.list(queryWrapper);
        return menu;
    }

}

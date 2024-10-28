package com.cxj.wash_car.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxj.wash_car.common.Cache;
import com.cxj.wash_car.common.ResultObj;
import com.cxj.wash_car.entity.AccountForm;
import com.cxj.wash_car.entity.Admin;
import com.cxj.wash_car.entity.User;
import com.cxj.wash_car.entity.Worker;
import com.cxj.wash_car.mapper.UserMapper;
import com.cxj.wash_car.service.IAdminService;
import com.cxj.wash_car.service.IUserService;
import com.cxj.wash_car.service.IWorkerService;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import static com.cxj.wash_car.common.Cache.map;
import static com.cxj.wash_car.common.ResultObj.*;
import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@RestController
public class RedirectController {

    @Autowired
    public IUserService iUserService;
    @Autowired
    public IWorkerService iWorkerService;
    @Autowired
    public IAdminService iAdminService;

    @GetMapping("/getCode")
    public String getCode() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String code = specCaptcha.text().toLowerCase();
        Cache.map.put("code",code);
        return specCaptcha.toBase64();
    }

    @GetMapping("/login")
    public ResultObj login(AccountForm accountForm){
        String code = map.get("code");
        ResultObj resultObj = null;
        switch(accountForm.getType()){
            //用户登录
            case 1:
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("username",accountForm.getLoginname());
                User user = iUserService.getOne(queryWrapper);
                if(user == null)
                    return LOGIN_ERROR_NAME;
                if(!user.getPassword().equals(accountForm.getPassword()))
                    return LOGIN_ERROR_PASSWORD;
                if(!code.equals(accountForm.getCode()))
                    return LOGIN_ERROR_CODE;
                resultObj=new ResultObj(0,"登录成功",user);
                return resultObj;
            //工人登录
            case 2:
                QueryWrapper<Worker> queryWrapper1 = new QueryWrapper<>();
                queryWrapper1.eq("username",accountForm.getLoginname());
                Worker worker = iWorkerService.getOne(queryWrapper1);
                if(worker == null)
                    return LOGIN_ERROR_NAME;
                if(!worker.getPassword().equals(accountForm.getPassword()))
                    return LOGIN_ERROR_PASSWORD;
                if(!code.equals(accountForm.getCode()))
                    return LOGIN_ERROR_CODE;
                resultObj=new ResultObj(0,"登录成功",worker);
                return resultObj;
            //管理员登录
            case 3:
                QueryWrapper<Admin> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("username",accountForm.getLoginname());
                Admin admin = iAdminService.getOne(queryWrapper2);
                if(admin == null)
                    return LOGIN_ERROR_NAME;
                if(!admin.getPassword().equals(accountForm.getPassword()))
                    return LOGIN_ERROR_PASSWORD;
                if(!code.equals(accountForm.getCode()))
                    return LOGIN_ERROR_CODE;
                resultObj=new ResultObj(0,"登录成功",admin);
                return resultObj;
        }
        return resultObj;
    }
}

package com.cxj.wash_car.service.impl;

import com.cxj.wash_car.entity.User;
import com.cxj.wash_car.mapper.UserMapper;
import com.cxj.wash_car.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxj
 * @since 2024-10-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

package com.rogear.mybatisplusgeneratordemo.users.service.impl;

import com.rogear.mybatisplusgeneratordemo.users.entity.User;
import com.rogear.mybatisplusgeneratordemo.users.mapper.UserMapper;
import com.rogear.mybatisplusgeneratordemo.users.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rogear
 * @since 2020-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

package com.rogear.mybatisplusgeneratordemo.users2.service.impl;

import com.rogear.mybatisplusgeneratordemo.users2.entity.User;
import com.rogear.mybatisplusgeneratordemo.users2.mapper.UserMapper;
import com.rogear.mybatisplusgeneratordemo.users2.service.IUserService;
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

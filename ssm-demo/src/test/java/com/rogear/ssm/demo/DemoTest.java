package com.rogear.ssm.demo;

import com.rogear.ssm.demo.dao.UserMapper;
import com.rogear.ssm.demo.entity.User;
import com.rogear.ssm.demo.entity.UserExample;
import com.rogear.ssm.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Rogear2008
 * @time 2022/5/25 23:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-persist-mybatis.xml","classpath:/spring-persist-tx.xml"})
public class DemoTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    private static Logger LOG = LoggerFactory.getLogger(DemoTest.class);

    @Test
    public void dataSourceTest() throws SQLException {
        System.out.println("dataSource:" + dataSource.getConnection());
    }

    @Test
    public void userTest() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        user.setCreateTime(new Date());
        user.setBirthday(new Date());
        user.setEnable(true);
        int insert = userMapper.insert(user);
        Assert.assertTrue(insert == 1);
    }

    @Test
    public void logTest() {
        LOG.trace("trace");
        LOG.debug("debug");
        LOG.info("info");
        LOG.warn("warn");
        LOG.error("error");
    }

    @Test
    public void adviceTest() {
        User user = userService.selectByPrimaryKey(1);
    }
}

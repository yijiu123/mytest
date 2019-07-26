package com.czxy.score.service.impl;

import com.czxy.score.dao.UserMapper;
import com.czxy.score.domain.User;
import com.czxy.score.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> findUsers(Integer mettingId) {
        return userMapper.findUsers(mettingId);
    }

    @Override
    public List<User> findUsersByDeptId(Integer deptId) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deptId",deptId);
        return userMapper.selectByExample(example);
    }


}

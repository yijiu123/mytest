package com.czxy.score.service;

import com.czxy.score.domain.User;

import java.util.List;

public interface UserService {

    public User login(User user);

    List<User> findUsers(Integer mettingId);

    List<User> findUsersByDeptId(Integer deptId);
}

package com.czxy.score.dao;


import com.czxy.score.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @Select("select * from tab_user where username=#{username} and password=#{password}")
    public User login(User user);

    @Select("select * from tab_user where user_id in(select user_id from tab_user_metting where metting_id = #{mettingId})")
    List<User> findUsers(@Param("mettingId") Integer mettingId);

    @Select("select * from tab_user where dept_id=#{deptId}")
    List<User> findUsersByDept(@Param("deptId") Integer deptId);

    List<User> findUsersByDeptId(Integer deptId);
}

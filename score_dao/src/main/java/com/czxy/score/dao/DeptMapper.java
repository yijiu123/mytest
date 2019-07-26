package com.czxy.score.dao;

import com.czxy.score.domain.Dept;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DeptMapper extends Mapper<Dept> {

    @Select("select * from tab_dept")
    @Results({
//            @Result(property = "deptId",column = "dept_id"),
//            @Result(property = "userList",many = @Many(select = "com.czxy.score.UserMapper.findUsersByDept"),column = "dept_id")
    })
    List<Dept> findAll();

}

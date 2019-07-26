package com.czxy.score.dao;

import com.czxy.score.domain.Metting;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MettingMapper extends Mapper<Metting> {


    @Select("select tab_metting.*,tab_room.* from tab_metting,tab_room where tab_room.room_id=tab_metting.room_id and username=#{username} and metting_starttime>='2019-07-25' and  metting_starttime<'2019-08-01'")
    @Results({
            @Result(property = "roomId",column = "room_id"),
            @Result(property = "room",one = @One(select = "com.czxy.score.dao.RoomMapper.selectByPrimaryKey"),column = "room_id")
    })
    List<Metting> getMetting(@Param("username") String username);


    @Select("select * from tab_metting where metting_id in(select metting_id from tab_user_metting where user_id = #{userId})")
    @Results({
            @Result(property = "roomId",column = "room_id"),
            @Result(property = "room",one = @One(select = "com.czxy.score.dao.RoomMapper.selectByPrimaryKey"),column = "room_id")
    })
    List<Metting> getMettingList(@Param("userId") Integer userId);
}

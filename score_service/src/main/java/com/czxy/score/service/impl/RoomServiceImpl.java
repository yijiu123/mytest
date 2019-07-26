package com.czxy.score.service.impl;

import com.czxy.score.dao.RoomMapper;
import com.czxy.score.domain.Room;
import com.czxy.score.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;


    @Override
    public List<Room> getAllRoom() {
        return roomMapper.selectAll();
    }
}

package com.czxy.score.controller;

import com.czxy.score.domain.Room;
import com.czxy.score.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomControler {

    @Resource
    private RoomService roomService;

    //获取所有的会议室
    @GetMapping()
    public ResponseEntity<List<Room>> getAllRoom(){
        List<Room> allRoom = roomService.getAllRoom();
        return ResponseEntity.ok(allRoom);
    }

}

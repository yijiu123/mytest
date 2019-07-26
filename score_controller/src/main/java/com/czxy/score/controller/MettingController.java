package com.czxy.score.controller;

import com.czxy.score.domain.Metting;
import com.czxy.score.domain.User;
import com.czxy.score.service.MettingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/metting")
public class MettingController {

    @Resource
    private MettingService mettingService;

    //查询我的会议
    @GetMapping("/getMettingList")
    public ResponseEntity<List<Metting>> getMettingList(HttpSession session,HttpServletResponse response){
        User user = (User) session.getAttribute("user");
        List<Metting> mettingList = mettingService.getMettingList(user.getUserId());
        return ResponseEntity.ok(mettingList);
    }


    //查询会议详情
    @GetMapping("/getMetting")
    public ResponseEntity getMetting(Integer mettingId, HttpServletResponse response){
        Metting metting = mettingService.findMetting(mettingId);
        return ResponseEntity.ok(metting);

    }

    //获取当前用户未来7天要参加未开始状态的会议
    @PostMapping("/getMettingList")
    public ResponseEntity<List<Metting>> getMVo(HttpSession session, HttpServletResponse response){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            try {
                List<Metting> mettingList = mettingService.getMVo(user.getUsername());
                return ResponseEntity.ok(mettingList);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }





}

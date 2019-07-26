package com.czxy.score.controller;

import com.czxy.score.domain.Dept;
import com.czxy.score.service.DeptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @PostMapping
    public ResponseEntity findAll(){
        List<Dept> deptList = deptService.findAll();
        return ResponseEntity.ok(deptList);
    }

}

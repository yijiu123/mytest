package com.czxy.score.controller;

import com.czxy.score.domain.User;
import com.czxy.score.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    //根据deptId查询users
    @RequestMapping("/findUsersByDeptId")
    public ResponseEntity findUsers(Integer deptId){
        List<User> userList = userService.findUsersByDeptId(deptId);
        return ResponseEntity.ok(userList);
    }

    //查询参会人员
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(Integer mettingId, HttpServletResponse response){
        List<User> users = userService.findUsers(mettingId);
        return ResponseEntity.ok(users);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletRequest request){
        User u = userService.login(user);
        request.getSession().setAttribute("user",u);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
	
	/**
		展示登录用户名
	*/
	@GetMapping("/searchName")
    public ResponseEntity<String> searchName(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            return new ResponseEntity<>(user.getUsername(),HttpStatus.OK);
        }
        return new ResponseEntity<>("null",HttpStatus.NO_CONTENT);
    }
    
}

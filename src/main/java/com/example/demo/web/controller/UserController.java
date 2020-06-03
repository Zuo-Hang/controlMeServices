package com.example.demo.web.controller;


import com.example.demo.base.JsonResult;
import com.example.demo.base.ResultTool;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: Hutengfei
 * @Description:
 * @Date Create in 2019/8/28 19:34
 */
@RestController
public class UserController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/getUser")
    public JsonResult getUser() {
        List<SysUser> users = sysUserService.queryAllByLimit(1, 100);
        System.out.println(users.toArray().toString());
        return ResultTool.success(users);
    }
    @GetMapping("/test")
    public JsonResult test() {
        return ResultTool.success("hello world");
    }

    @PostMapping("/registerUser")
    public JsonResult registerUser(SysUser user){
        System.out.println(user);
        user.setAccount(user.getUserName());
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        SysUser insert = sysUserService.insert(user);
        //userMapper.insertUser(user);

        return ResultTool.success(insert);
    }
}

package com.example.demo.web.controller;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zuohang
 * @date:2020/5/13 0013 18:23
 */

@RestController
public class DeptController {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/dept/{id}")
    public Role getRole(@PathVariable("id") Integer id){
        return roleMapper.getRoleByid(id);
    }

    @GetMapping("/user/ins")
    public void insertUser(User user) {
        System.out.println(user);
        user.setName(user.getPhoneNumber());
        user.setSex("男");
        userMapper.insertUser(user);
    }
    @GetMapping("/user/login")
    public Map<String, String> login(User user){
        HashMap<String, String> map = new HashMap<>();
        if(user.getPhoneNumber() .equals("15389425034")  &&user.getPassword().equals("123456")){
            map.put("msg","登录成功");
        }else {
            map.put("msg","账号或密码错误");
        }
        return map;
    }
}

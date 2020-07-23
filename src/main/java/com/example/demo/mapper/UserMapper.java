package com.example.demo.mapper;

import com.example.demo.bean.User;

/**
 * @Author:zuohang
 * @date:2020/5/13 0013 18:40
 */
public interface UserMapper {
    //根据id查询用户信息
    public User findUserById(Integer id);

    //新增用户
    public void insertUser(User user);

    //更新用户信息
    public void upDateUser(User user);

    public void upDateHeadShot(String string);
}

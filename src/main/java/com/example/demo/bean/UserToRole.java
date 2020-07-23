package com.example.demo.bean;

/**
 * 人员映射
 * 将用户与分组绑定
 * @Author:zuohang
 * @date:2020/5/13 0013 11:32
 */
public class UserToRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;

    public UserToRole() {
    }

    public UserToRole(Integer id, Integer userId, Integer roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserToRole{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}

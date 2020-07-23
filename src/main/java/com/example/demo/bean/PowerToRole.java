package com.example.demo.bean;

/**
 *
 * 权限映射
 * 将活动与用户组映射起来
 * @Author:zuohang
 * @date:2020/5/13 0013 11:30
 */
public class PowerToRole {
    //记录的id
    private Integer id;
    private Integer powerId;
    private Integer roleId;

    public PowerToRole() {
    }

    public PowerToRole(Integer id, Integer powerId, Integer roleId) {
        this.id = id;
        this.powerId = powerId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "PowerToRole{" +
                "id=" + id +
                ", powerId=" + powerId +
                ", roleId=" + roleId +
                '}';
    }
}

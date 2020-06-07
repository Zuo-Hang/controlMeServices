package com.example.demo.entity;

/**
 * 用户设备关系实例
 * @Author:zuohang
 * @date:2020/6/7 0007 22:27
 */
public class SysUserEquipment {
    //id
    Integer id;
    //用户id
    Integer userId;
    //设备id
    Integer equId;
    //备注信息
    String notes;

    public SysUserEquipment() {
    }

    public SysUserEquipment(Integer userId, Integer equId, String notes) {
        this.userId = userId;
        this.equId = equId;
        this.notes = notes;
    }

    public SysUserEquipment(Integer id, Integer userId, Integer equId, String notes) {
        this.id = id;
        this.userId = userId;
        this.equId = equId;
        this.notes = notes;
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

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "SysUserEquipment{" +
                "id=" + id +
                ", userId=" + userId +
                ", equId=" + equId +
                ", notes='" + notes + '\'' +
                '}';
    }
}

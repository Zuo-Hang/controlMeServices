package com.example.demo.bean;

/**
 * 权限：
 * 规定拥有该权限的角色在整个项目中可以进行的操作
 * @Author:zuohang
 * @date:2020/5/13 0013 11:16
 */
public class Power {
    private Integer powerId;
    private String powerName;
    private String description;

    public Power() {
    }

    public Power(Integer powerId, String powerName, String description) {
        this.powerId = powerId;
        this.powerName = powerName;
        this.description = description;
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Power{" +
                "powerId=" + powerId +
                ", powerName='" + powerName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

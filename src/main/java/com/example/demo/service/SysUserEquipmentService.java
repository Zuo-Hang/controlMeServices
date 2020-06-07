package com.example.demo.service;

import com.example.demo.entity.SysUserEquipment;

/**
 * @Author:zuohang
 * @date:2020/6/7 0007 22:49
 */
public interface SysUserEquipmentService {
    /**
     * 按id查询
     * @param id
     * @return
     */
    SysUserEquipment queryById(Integer id);

    /**
     * 插入
     * @param sysUserEquipment
     * @return
     */
    SysUserEquipment insert(SysUserEquipment sysUserEquipment);

    /**
     * 更新
     * @param sysUserEquipment
     * @return
     */
    SysUserEquipment update(SysUserEquipment sysUserEquipment);

    /**
     * 按用户id和设备id查询
     * @param userId
     * @param equId
     * @return
     */
    SysUserEquipment queryByUserIdAndEquId(Integer userId,Integer equId);

    /**
     * 按id删除
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}

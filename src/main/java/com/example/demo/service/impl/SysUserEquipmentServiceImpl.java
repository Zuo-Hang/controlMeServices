package com.example.demo.service.impl;

import com.example.demo.dao.SysUserEquipmentDao;
import com.example.demo.entity.SysUserEquipment;
import com.example.demo.service.SysUserEquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author:zuohang
 * @date:2020/6/7 0007 22:50
 */
@Service("sysUserEquipmentService")
public class SysUserEquipmentServiceImpl implements SysUserEquipmentService {

    @Resource
    SysUserEquipmentDao sysUserEquipmentDao;

    @Override
    public SysUserEquipment queryById(Integer id) {
        return sysUserEquipmentDao.queryById(id);
    }

    @Override
    public SysUserEquipment insert(SysUserEquipment sysUserEquipment) {
        sysUserEquipmentDao.insert(sysUserEquipment);
        return sysUserEquipment;
    }

    @Override
    public SysUserEquipment update(SysUserEquipment sysUserEquipment) {
        return sysUserEquipmentDao.update(sysUserEquipment);
    }

    @Override
    public SysUserEquipment queryByUserIdAndEquId(Integer userId, Integer equId) {
        return sysUserEquipmentDao.queryByUserIdAndEquId(userId, equId);
    }

    @Override
    public boolean deleteById(Integer id) {
        return sysUserEquipmentDao.deleteById(id)>0;
    }
}

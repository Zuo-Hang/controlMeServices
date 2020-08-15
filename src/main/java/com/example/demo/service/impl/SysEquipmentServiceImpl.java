package com.example.demo.service.impl;

import com.example.demo.dao.SysEquipmentDao;
import com.example.demo.entity.EquipmentBean;
import com.example.demo.service.SysEquipmentService;
import com.example.demo.simple.ClientHelloWorld;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 设备表(SysUser)表服务实现接口
 * @Author:zuohang
 * @date:2020/6/4 0004 19:53
 */
@Service("sysEquipmentService")
public class SysEquipmentServiceImpl implements SysEquipmentService {
@Resource
    ClientHelloWorld clientHelloWorld;

    @Resource
    SysEquipmentDao sysEquipmentDao;
    @Override
    public EquipmentBean queryById(Integer id) {
        return sysEquipmentDao.queryById(id);
    }

    @Override
    public List<EquipmentBean> getAll() {
        return sysEquipmentDao.getAll();
    }

    @Override
    public EquipmentBean insert(EquipmentBean equipmentBean) {
        //返回的是这条sql执行后的影响数，并非主键
        Integer insert = sysEquipmentDao.insert(equipmentBean);
        return equipmentBean;
    }

    @Override
    public EquipmentBean update(EquipmentBean equipmentBean) {
        sysEquipmentDao.update(equipmentBean);
        return equipmentBean;
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.sysEquipmentDao.deleteById(id)>0;
    }

    /**
     * 控制功能
     * @param id
     * @return
     */
    @Override
    public boolean control(Integer id) {
        clientHelloWorld.start(id);
        return false;
    }
}

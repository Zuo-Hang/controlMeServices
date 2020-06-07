package com.example.demo.service;

import com.example.demo.entity.EquipmentBean;

import java.util.List;

/**
 * 设备表(SysUser)表服务接口
 * @Author:zuohang
 * @date:2020/6/4 0004 19:51
 */
public interface SysEquipmentService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EquipmentBean queryById(Integer id);

    List<EquipmentBean> getAll();

    /**
     * 新增数据
     *
     * @param equipmentBean 实例对象
     * @return 实例对象
     */
    EquipmentBean insert(EquipmentBean equipmentBean);

    /**
     * 修改数据
     *
     * @param equipmentBean 实例对象
     * @return 实例对象
     */
    EquipmentBean update(EquipmentBean equipmentBean);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

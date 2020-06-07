package com.example.demo.dao;

import com.example.demo.entity.EquipmentBean;

import java.util.List;

/**
 * 设备表(SysEquipment)表数据库访问层
 * @Author:zuohang
 * @date:2020/6/4 0004 20:02
 */
public interface SysEquipmentDao {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EquipmentBean queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象的集合
     */
    List<EquipmentBean> getAll();

    /**
     * 新增数据
     *
     * @param equipmentBean 实例对象
     * @return 实例对象
     */
    Integer insert(EquipmentBean equipmentBean);

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
    Integer deleteById(Integer id);
}

package com.example.demo.web.controller;

import com.example.demo.base.JsonResult;
import com.example.demo.base.ResultTool;
import com.example.demo.entity.EquipmentBean;
import com.example.demo.entity.SysUserEquipment;
import com.example.demo.service.SysEquipmentService;
import com.example.demo.service.SysUserEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 设备Controller
 *
 * @Author:zuohang
 * @date:2020/6/4 0004 19:50
 */
@RestController
public class EquipmentController {
    @Autowired
    SysEquipmentService sysEquipmentService;
    @Autowired
    SysUserEquipmentService sysUserEquipmentService;

    @GetMapping("/getEquipment")
    public JsonResult getEquipment(int id) {
        EquipmentBean equipmentBean = sysEquipmentService.queryById(id);
        return ResultTool.success(equipmentBean);
    }

    @PostMapping("/addEquipment")
    public JsonResult addEquipment(EquipmentBean equipmentBean,String notes,Integer id) {
        System.out.println(equipmentBean);
        //插入设备表
        EquipmentBean insert = sysEquipmentService.insert(equipmentBean);
        SysUserEquipment sysUserEquipment = new SysUserEquipment(id, insert.getEquId(), notes);
        //插入关系表
        sysUserEquipmentService.insert(sysUserEquipment);
        return ResultTool.success(insert);
    }

    @GetMapping("/getAll")
    public JsonResult getAll(){
        List<EquipmentBean> all = sysEquipmentService.getAll();
        return ResultTool.success(all);
    }

    @GetMapping("/deleteById")
    public JsonResult deleteById(int id){
        boolean b = sysEquipmentService.deleteById(id);
        //List<EquipmentBean> all = sysEquipmentService.getAll();
        return ResultTool.success(b);
    }
}

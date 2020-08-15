package com.example.demo.service.impl;

import com.example.demo.dao.sysUserRoleRelationDao;
import com.example.demo.entity.SysUserRoleRelation;
import com.example.demo.service.SysUserRoleRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author:zuohang
 * @date:2020/6/30 0030 11:44
 */

@Service("sysUserRoleRelationServiceImpl")
public class SysUserRoleRelationServiceImpl implements SysUserRoleRelationService {
    @Resource
    sysUserRoleRelationDao sysUserRoleRelationDao;
    @Override
    public void insertrole(SysUserRoleRelation sysUserRoleRelation) {
        sysUserRoleRelationDao.insertrole(sysUserRoleRelation);
    }
}

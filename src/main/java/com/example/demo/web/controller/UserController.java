package com.example.demo.web.controller;


import com.example.demo.base.JsonResult;
import com.example.demo.base.ResultTool;
import com.example.demo.entity.SysUser;
import com.example.demo.entity.SysUserRoleRelation;
import com.example.demo.service.AliyunossService;
import com.example.demo.service.SysUserService;
import com.example.demo.service.impl.SysUserRoleRelationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @Author: Hutengfei
 * @Description:
 * @Date Create in 2019/8/28 19:34
 */
@RestController
public class UserController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AliyunossService aliyunossService;
    @Autowired
    SysUserRoleRelationServiceImpl sysUserRoleRelationServiceImpl;
    /**
     * 获取用户
     *
     * @return
     */
    @GetMapping("/getUser")
    public JsonResult getUser(int id) {
        SysUser sysUser = sysUserService.queryById(id);
//        List<SysUser> users = sysUserService.queryAllByLimit(1, 100);
//        System.out.println(users.toArray().toString());
        return ResultTool.success(sysUser);
    }

    @GetMapping("/test")
    public JsonResult test() {
        return ResultTool.success("hello world");
    }

    /**
     * 注册账号
     *
     * @param user
     * @return
     */
    @PostMapping("/registerUser")
    public JsonResult registerUser(SysUser user) {
        System.out.println(user);
        user.setAccount(user.getUserName());
        user.setHeadShot("defult.png");
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        SysUser insert = sysUserService.insert(user);
        System.out.println(insert);
        SysUserRoleRelation sysUserRoleRelation = new SysUserRoleRelation();
        sysUserRoleRelation.setUser_id(insert.getId());
        sysUserRoleRelation.setRole_id(1);
        sysUserRoleRelationServiceImpl.insertrole(sysUserRoleRelation);

        return ResultTool.success(insert);
    }

    /**
     * 上传头像
     *
     * @param uploadFile 从客户端传过来的文件
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addheadshot", method = RequestMethod.POST)
    public JsonResult add(@RequestParam("files") MultipartFile uploadFile, @RequestParam("userId") String userId) throws IOException {
        String originalFilename = uploadFile.getOriginalFilename();
        String base = "D:\\javaProject\\controlMeServices\\tmp\\";
        File file = new File(base + originalFilename);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        try {
            //将图片写到本地
            uploadFile.transferTo(file);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        //调用阿里云上传
        String put = aliyunossService.put(file, userId);
        int id = Integer.parseInt(userId);
        //更新数据库中的头像地址
        SysUser sysUser = sysUserService.queryById(id);
        sysUser.setHeadShot(put);
        SysUser update = sysUserService.update(sysUser);
        return ResultTool.success(update);
    }

    /**
     * 更新信息
     *
     * @param user
     * @return
     */
    @PostMapping("/updateuser")
    public JsonResult updateuser(SysUser user) {
        System.out.println(user);
        user.setAccount(user.getUserName());
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        SysUser update = sysUserService.update(user);
        return ResultTool.success(update);
    }
}

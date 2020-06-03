package com.example.demo.service;

import java.io.File;

/**
 * @Author:zuohang
 * @date:2020/6/3 0003 15:29
 */
public interface AliyunossService {
    /**
     * 向阿里云上传图片
     * @return
     */
    String put(File file,String userId);
}

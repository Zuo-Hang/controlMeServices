package com.example.demo.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.example.demo.service.AliyunossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 阿里云的oss服务
 * @Author:zuohang
 * @date:2020/6/3 0003 15:32
 */

@Service("aliyunossService")
public class AliyunossServiceImpl implements AliyunossService {

    @Override
    public String put(File file,String userId) {
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4G1oUYXqZyZS43yTfikm";
        String accessKeySecret = "qD1hZ8AsbWaSfSfzvJdsLoQE37DR4b";
        String bucketName = "android-me";
        String key = userId+"_"+file.getName();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        //发送oss请求
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();
        return key;
    }
}

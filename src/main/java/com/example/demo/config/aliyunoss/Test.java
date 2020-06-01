package com.example.demo.config.aliyunoss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;

/**
 * @Author:zuohang
 * @date:2020/5/12 0012 12:48
 */


/**
 * 测试阿里云的oss服务
 */
public class Test {
    public static void main(String[] args) {
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4G1oUYXqZyZS43yTfikm";
        String accessKeySecret = "qD1hZ8AsbWaSfSfzvJdsLoQE37DR4b";
        String bucketName = "android-me";
        String key = "key.png";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, new File("D:\\javaProject\\controlMeServices\\tmp\\2.png"));

        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}

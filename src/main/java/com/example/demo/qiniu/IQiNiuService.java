//package com.example.demo.qiniu;
//
//import com.qiniu.common.QiniuException;
//import com.qiniu.http.Response;
//
//import java.io.File;
//import java.io.InputStream;
//
///**
// * 七牛云服务
// */
//public interface IQiNiuService {
//    //通过文件上传
//    Response uploadFile(File file) throws QiniuException;
//    //用文件流上传
//    Response uploadFile(InputStream inputStream) throws QiniuException;
//    //删除需求
//    Response delete(String key) throws QiniuException;
//}
//
///**
// * 功能的设计：从上至下
// * 接口的实现：从下至上的
// */
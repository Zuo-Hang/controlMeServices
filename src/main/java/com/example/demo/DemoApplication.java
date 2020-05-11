package com.example.demo;

import com.example.demo.http.TestServer;
import com.example.demo.qiniu.QiNiuServiceImpl;
import com.example.demo.simple.NettyServer;
import com.qiniu.common.QiniuException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.io.File;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Resource
    private NettyServer nettyServer;
    @Resource
    private TestServer testServer;
    @Resource
    protected   QiNiuServiceImpl qiNiuService;
    public static void main(String[] args) throws QiniuException {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 测试的结果只能启动一个netty服务
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
//        D:\javaProject\controlMeServices\tmp\1.png
        File target = new File("D:\\javaProject\\controlMeServices\\tmp\\1.png");
        qiNiuService.uploadFile(target);
//        testServer.start();
//        nettyServer.start();
    }
}

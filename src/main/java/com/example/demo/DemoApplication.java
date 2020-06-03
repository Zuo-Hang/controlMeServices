package com.example.demo;

import com.example.demo.http.TestServer;
import com.example.demo.simple.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@MapperScan(value = "com.example.demo.dao")
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Resource
    private NettyServer nettyServer;
    @Resource
    private TestServer testServer;

    /**
     * 启动8080端口的服务
     * @param args
     */
    public static void main(String[] args)  {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 测试的结果只能启动一个netty服务
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
//        D:\javaProject\controlMeServices\tmp\2.png
        //File target = new File("D:\\javaProject\\controlMeServices\\tmp\\2.png");
        //qiNiuService.uploadFile(target);
//        testServer.start();
        nettyServer.start();
    }
}

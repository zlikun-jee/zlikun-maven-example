package com.zlikun.jee;

import com.zlikun.jee.service.HelloService;
import com.zlikun.jee.service.impl.HelloServiceImpl;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zlikun
 * @date 2018-09-30 16:59
 */
public class Main {

    /**
     * 使用如下命令启动打包后的程序
     * $ java -classpath lib/zlikun-maven-example-1.0.0.jar com.zlikun.jee.Main
     * Hello Kevin !
     *
     * @param args
     */
    public static void main(String[] args) {

        // 测试接口
        HelloService service = new HelloServiceImpl();
        String message = service.hello("Kevin");
        System.out.println(message);

        // 配置文件
        Properties props = new Properties();
        try {
            props.load(Main.class.getClassLoader().getResourceAsStream("config.properties"));
            System.out.println(props.getProperty("redis.host"));
            System.out.println(props.getProperty("redis.port"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

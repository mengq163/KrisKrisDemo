package com.kris.demo.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(value=2)
public class StartupRunnerTwo implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        for (String arg : args) {
            System.out.println(arg);
        }

        System.out.println(">>>>>>>>>>>>>>>服务启动第二个开始执行的任务，执行加载数据等操作<<<<<<<<<<<<<" + Arrays.asList(args));
    }
}

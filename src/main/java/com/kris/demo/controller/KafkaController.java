package com.kris.demo.controller;

import com.kris.demo.entity.User;
import com.kris.demo.service.KafkaProducer;
import com.kris.demo.service.KafkaUserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * PS:@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaUserConsumer kafkaUserConsumer;

    @RequestMapping("/createMsg")
    public void createMsg() {
        User user = new User();
        user.setId(1000L);
        user.setUserName("testName");
        user.setNickName("昵称11112222");
        kafkaProducer.sendUserMessage(user);
    }

    @GetMapping("/readMsg")
    public void readMsg() {
        kafkaUserConsumer.consume();
    }
}

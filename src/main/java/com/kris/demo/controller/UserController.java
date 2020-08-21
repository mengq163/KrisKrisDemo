package com.kris.demo.controller;

import com.github.pagehelper.PageInfo;
import com.kris.demo.entity.Librarian;
import com.kris.demo.entity.OrderPresentInfo;
import com.kris.demo.entity.User;
import com.kris.demo.service.impl.UserServiceImpl;
import com.kris.demo.service.LibrarianService;
import com.kris.demo.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:kris
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */
@Api(tags="用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    LibrarianService librarianService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    RedisUtil redisUtil;

    @ApiOperation("用户详情")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable Long id){

        logger.info("getUser Start: " + id);

        List<String> list1 = new ArrayList<>();
        list1.add("1111");
        list1.add("2222");
        redisUtil.lSet("test1", list1);


        List<Object> bbb = redisUtil.lGet("test1", 0, -1);

        for ( Object b : bbb) {
            logger.info("Redis:" + b.toString());
        }



       User user =  userService.getUser(id);

        logger.info("getUser End");

       return user;

    }

    @GetMapping("getLibrarian/{id}")
    public Librarian GetLibrarian(@PathVariable Long id){
        return librarianService.selectLibrarian(id);
    }
    @ApiOperation("用户详情列表")
    @GetMapping("/getUsers")
    public PageInfo<User> getUsers(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize) {
        logger.info("getUsers");
        PageInfo<User> page = userService.getUsers(pageNo, pageSize);
        return  page;
    }



}
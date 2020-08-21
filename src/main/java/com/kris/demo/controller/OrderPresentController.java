package com.kris.demo.controller;

import com.github.pagehelper.PageInfo;
import com.kris.demo.entity.OrderPresentInfo;
import com.kris.demo.service.OrderPresentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/")
public class OrderPresentController {

    @Autowired
    private OrderPresentInfoService orderPresentService;


    /**
     * 跳转到应用列表页面
     * @param pageNo 要显示第几页内容
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping("/list")
    public PageInfo<OrderPresentInfo> list(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize) {
        PageInfo<OrderPresentInfo> page = orderPresentService.getAllOrderPresentForPage(pageNo,pageSize);
        return  page;
    }





    @RequestMapping("/")
    public String helloHtml(HashMap<String, Object> map, Model model) {
        model.addAttribute("say","欢迎欢迎,热烈欢迎");
        map.put("hello", "欢迎进入HTML页面");
        return "index";
    }

    @RequestMapping("/goToAdd")
    public String goToAdd() {
        return "add";
    }

    @RequestMapping("/add")
    public String add(OrderPresentInfo orderPresent) {
        return "添加成功";
    }

}


package com.hqyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author  Jayoung
 * createDate  2020/8/3 0003 15:06
 * version 1.0
 */
@Controller
@RequestMapping("cc")
public class CustomerController {
    @RequestMapping("index.do")
    public String index(){
        return "index";
    }


    @RequestMapping("index1.do")
    public String index1(){
        return "index";
    }
}

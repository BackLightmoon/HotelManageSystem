package com.hqyj.controller;

import com.hqyj.pojo.House1;
import com.hqyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * author  Jayoung
 * createDate  2020/8/3 0003 15:05
 * version 1.0
 */
@Controller
@RequestMapping("uc")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("list.do")
    public String list(House1 house1, ModelMap map) {
        HashMap<String, Object> listMap = service.selectByPage(house1);
        map.addAttribute("data", listMap);
        //定义返回的页面
        return "user/roomManagerPage";
    }

    @RequestMapping("roomEditPage.do")
    public String roomEditPage(@RequestParam("hId") int hId, ModelMap map){
        House1 houser1=service.selectByHid(hId);
        map.addAttribute("house",houser1);

        return "user/roomEditPage";
    }
    @RequestMapping(method = RequestMethod.POST, value = "roomEdit.do")
    public String roomEdit(House1 houser1, ModelMap map) {
        if (service.update(houser1) > 0) {
            //刷新
            House1 houser2 = new House1();
            HashMap<String, Object> listMap = service.selectByPage(houser2);
            map.addAttribute("data", listMap);
            //redirect:url地址：重定向
            return "redirect:list.do";
        } else {
            map.addAttribute("info", "修改失败");
            return "user/roomEditPage";
        }
    }
    @RequestMapping("delete.do")
    public String delete(int hId, ModelMap map){
        if (service.del(hId) > 0) {
            //刷新
            House1 house = new House1();
            HashMap<String, Object> listMap = service.selectByPage(house);
            map.addAttribute("data", listMap);
            //redirect:url地址：重定向
        }
        return "redirect:list.do";
    }
    @RequestMapping("roomAddPage.do")
    public String roomAddPage(){
        return "user/roomAddPage";
    }
    @RequestMapping(method = RequestMethod.POST, value = "roomAdd.do")
    public String roomAdd(House1 houser1, ModelMap map) {
        if (service.insert(houser1) > 0) {
            //刷新
            House1 houser2 = new House1();
            HashMap<String, Object> listMap = service.selectByPage(houser2);
            map.addAttribute("data", listMap);
            //redirect:url地址：重定向
            return "redirect:list.do";
        } else {
            map.addAttribute("info", "修改失败");
            return "user/roomAddPage";
        }
    }
    @RequestMapping("deleteAll.do")
    public String deleteAll( String allId, ModelMap map){
        List<String> list = Arrays.asList(allId.split(","));
        if(service.delAll(list)>0){
            //刷新
            House1 house = new House1();
            HashMap<String, Object> listMap = service.selectByPage(house);
            map.addAttribute("data", listMap);
        }
        return "redirect:list.do";
    }
    @RequestMapping("factorQuery.do")
    public String factorQuery(House1 house1, ModelMap map,String factor,String keywords) {
        if (factor.equals("floorId")){
            house1.setFloorId(Integer.valueOf(keywords));
        }else if (factor.equals("hAmount")){
            house1.sethAmount(Integer.valueOf(keywords));
        }else if (factor.equals("hState")){
            house1.sethState(Integer.valueOf(keywords));
        }else if (factor.equals("hName")){
            house1.sethName(keywords);
        }else {

        }
        System.err.println("---------------------house1--------------------------- = " + house1.toString());
        HashMap<String, Object> listMap = service.selectByPage(house1);
        map.addAttribute("data", listMap);

        map.addAttribute("factor", factor);
        map.addAttribute("keywords", keywords);

        //定义返回的页面
        return "user/roomManagerPage";
    }
}

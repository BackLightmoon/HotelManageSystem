package com.hqyj.service;

import com.hqyj.pojo.House1;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/4
 * Time: 9:58
 * Description: No Description
 */
public interface UserService {
    //查询分页
    HashMap<String,Object> selectByPage(House1 house1);

    House1 selectByHid(int hId);

    int update(House1 houser1);

    int del(int hId);

    int insert(House1 houser1);

    int delAll(List<String> list);
}

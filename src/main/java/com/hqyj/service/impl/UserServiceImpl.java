package com.hqyj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.House1Mapper;
import com.hqyj.pojo.House1;
import com.hqyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/4
 * Time: 9:59
 * Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private House1Mapper dao;

    public HashMap<String, Object> selectByPage(House1 house1) {
        //1、设置分页参数，页码和每页显示行数
        PageHelper.startPage(house1.getPage(),house1.getRow());
        //2、查询自定义的sql
        List<House1> list =dao.selectByPage(house1);
        //3、转换为分页对象
        PageInfo<House1> pageInfo =new PageInfo<House1>(list);

        //构建数据类型
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("list",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());
        map.put("indexPage",pageInfo.getFirstPage());
        map.put("endPage",pageInfo.getLastPage());
        map.put("allPage",pageInfo.getPageSize());
        return map;
    }

    public House1 selectByHid(int hId) {
        return dao.selectByPrimaryKey(hId);
    }

    public int update(House1 houser1) {
        return dao.updateByPrimaryKeySelective(houser1);
    }

    public int del(int hId) {
        return dao.deleteByPrimaryKey(hId);
    }

    public int insert(House1 houser1) {
        return dao.insertSelective(houser1);
    }

    public int delAll(List<String> list) {
        return dao.delAll(list);
    }
}

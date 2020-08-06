package com.hqyj.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/4
 * Time: 9:10
 * Description: No Description
 */
public class MyPage{
    private int page=1;
    private int row=6;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
package com.lengedyun.easypoi.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import java.io.Serializable;

/**
 * @title: TimeBo
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/4/26 19:07
 */
public class TimeBo implements Serializable {

    @Excel(name = "时间")
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TimeBo(String time) {
        this.time = time;
    }
}

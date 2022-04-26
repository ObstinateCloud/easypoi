package com.lengedyun.easypoi.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @title: CityWeatherScatter
 * @description: 城市天气散点图
 * @auther: zhangjianyun
 * @date: 2022/4/20 16:25
 */

@ExcelTarget("CityWeatherScatter")
public class CityWeatherScatter2 implements Serializable {

    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name = "日期",exportFormat="yyyy-MM-dd",orderNum = "2")
    private Date date;

    @ExcelCollection(name = "时间",orderNum = "0")
    private List<TimeBo> timeList;

//    @ExcelCollection(name = "温度",orderNum = "1")
//    private List<Float> temperatureList;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<TimeBo> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<TimeBo> timeList) {
        this.timeList = timeList;
    }

    //    public List<Float> getTemperatureList() {
//        return temperatureList;
//    }
//
//    public void setTemperatureList(List<Float> temperatureList) {
//        this.temperatureList = temperatureList;
//    }

    public CityWeatherScatter2(Date date, List<TimeBo> timeList) {
        this.date = date;
        this.timeList = timeList;
    }


}

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
public class CityWeatherScatter1 implements Serializable {

    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name = "日期",exportFormat="yyyy-MM-dd",orderNum = "0")
    private Date date;

//    @ExcelCollection(name = "时间",orderNum = "0")
//    private List<String> timeList;
//
//    @ExcelCollection(name = "温度",orderNum = "1")
//    private List<Float> temperatureList;

    @Excel(name = "时间",orderNum = "0")
    private String timeList;

    @Excel(name = "温度",orderNum = "1")
    private Float temperatureList;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
//
//    public List<String> getTimeList() {
//        return timeList;
//    }
//
//    public void setTimeList(List<String> timeList) {
//        this.timeList = timeList;
//    }
//
//    public List<Float> getTemperatureList() {
//        return temperatureList;
//    }
//
//    public void setTemperatureList(List<Float> temperatureList) {
//        this.temperatureList = temperatureList;
//    }

//    public CityWeatherScatter(Date date, List<String> timeList, List<Float> temperatureList) {
//        this.date = date;
//        this.timeList = timeList;
//        this.temperatureList = temperatureList;
//    }


    public CityWeatherScatter1(Date date, String timeList, Float temperatureList) {
        this.date = date;
        this.timeList = timeList;
        this.temperatureList = temperatureList;
    }

    public String getTimeList() {
        return timeList;
    }

    public void setTimeList(String timeList) {
        this.timeList = timeList;
    }

    public Float getTemperatureList() {
        return temperatureList;
    }

    public void setTemperatureList(Float temperatureList) {
        this.temperatureList = temperatureList;
    }
}

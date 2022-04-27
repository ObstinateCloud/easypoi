package com.lengedyun.easypoi.bo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
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

    private List<ExcelExportEntity> entities;

    @ExcelCollection(name = "时间",orderNum = "0")
    private List<TimeBo> timeList;


    public List<TimeBo> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<TimeBo> timeList) {
        this.timeList = timeList;
    }

    public CityWeatherScatter2(List<ExcelExportEntity> entities, List<TimeBo> timeList) {
        this.entities = entities;
        this.timeList = timeList;
    }


}

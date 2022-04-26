package com.lengedyun.easypoi.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.export.base.ExportCommonService;
import com.lengedyun.easypoi.bo.CityWeatherScatter1;
import com.lengedyun.easypoi.bo.CityWeatherScatter2;
import com.lengedyun.easypoi.bo.TimeBo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.*;

/**
 *@ClassNameExportWordController
 *@Description描述:
 *
 *@Date2021/6/29 15:29
 *@Version1.0
 **/
@RestController
@RequestMapping("/export/")
public class ExportExcelController extends ExportCommonService {

    /**
     * easypoi导出excel 简单表格导出
     */
    @GetMapping("excel1")
    public void easyExportExcel1(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<CityWeatherScatter1> cityWeatherScatters = new ArrayList<>();
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(),"1:00",16.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(),"2:00",17.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(),"3:00",18.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(),"4:00",14.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(),"5:00",19.8f));

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("表格导出","天气表格","测试数据"), CityWeatherScatter1.class, cityWeatherScatters);
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=" + "CityWeatherScatter.xlsx");
        OutputStream fos = response.getOutputStream();
        workbook.write(fos);
        fos.close();
    }

    @GetMapping("excel2")
    public void easyExportExcel2(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<CityWeatherScatter2> cityWeatherScatters = new ArrayList<>();
        List<TimeBo> time = new ArrayList<>();
        time.add(new TimeBo("1:00"));
        time.add(new TimeBo("2:00"));
        time.add(new TimeBo("3:00"));
        time.add(new TimeBo("4:00"));
        time.add(new TimeBo("5:00"));
//        List<Float> temperature = new ArrayList<>();
//        temperature.add(26.1f);
//        temperature.add(26.1f);
//        temperature.add(26.8f);
//        temperature.add(26.9f);
//        temperature.add(25.3f);
//        temperature.add(25.1f);
        CityWeatherScatter2 cityWeatherScatter = new CityWeatherScatter2(new Date(),time);
        cityWeatherScatters.add(new CityWeatherScatter2(new Date(),time));
        cityWeatherScatters.add(new CityWeatherScatter2(new Date(),time));
        cityWeatherScatters.add(new CityWeatherScatter2(new Date(),time));
        cityWeatherScatters.add(new CityWeatherScatter2(new Date(),time));
        cityWeatherScatters.add(new CityWeatherScatter2(new Date(),time));

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("表格导出","天气表格","测试数据"), CityWeatherScatter2.class, cityWeatherScatters);
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=" + "CityWeatherScatter.xlsx");
        OutputStream fos = response.getOutputStream();
        workbook.write(fos);
        fos.close();
    }




}



package com.lengedyun.easypoi.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.export.base.ExportCommonService;
import com.lengedyun.easypoi.bo.CityWeatherScatter1;
import com.lengedyun.easypoi.bo.CityWeatherScatter2;
import com.lengedyun.easypoi.bo.TimeBo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @ClassNameExportWordController
 * @Description描述:
 * @Date2021/6/29 15:29
 * @Version1.0
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
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(), "1:00", 16.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(), "2:00", 17.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(), "3:00", 18.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(), "4:00", 14.8f));
        cityWeatherScatters.add(new CityWeatherScatter1(new Date(), "5:00", 19.8f));

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("表格导出", "天气表格", "测试数据"), CityWeatherScatter1.class, cityWeatherScatters);
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

        //填充表头
        List<ExcelExportEntity> entityList = new ArrayList<>();
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        for (int i = 0; i < 10; i++) {
            String date = simpleDateFormat.format(instance.getTime());
            dateList.add(date);
            entityList.add(new ExcelExportEntity(date,date));
            instance.add(Calendar.DATE,1);
        }



        List<Map<String, Object>> dataMapList = new ArrayList<>();
        Map<String,Object> map ;
        for (int i = 0; i < 50; i++) {
            map = new HashMap<>();
            for (String s : dateList) {
                map.put(s,s+"_"+i);
            }
            dataMapList.add(map);
        }

        ExportParams exportParams = new ExportParams("表格导出", "天气表格", "测试数据");
        exportParams.setFreezeCol(1);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, entityList, dataMapList);
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=" + "CityWeatherScatter.xlsx");
        OutputStream fos = response.getOutputStream();
        workbook.write(fos);
        fos.close();
    }

    @GetMapping("excel3")
    public void easyExportExcel3(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Map<String, Object>> dataMap = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "zjy1");
        map1.put("sex", "男");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "zjy2");
        map2.put("sex", "女");


        dataMap.add(map1);
        dataMap.add(map2);

        List<ExcelExportEntity> entity = new ArrayList<>();

        entity.add(new ExcelExportEntity("姓名", "name"));
        entity.add(new ExcelExportEntity("性别", "sex"));

        ExcelExportEntity excelExportEntity = new ExcelExportEntity("姓名", "name");


        ExportParams exportParams = new ExportParams("表格导出", "天气表格", "测试数据");


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("表格导出", "天气表格", "测试数据"), entity, dataMap);
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=" + "CityWeatherScatter.xlsx");
        OutputStream fos = response.getOutputStream();
        workbook.write(fos);
        fos.close();
    }


}



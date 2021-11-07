package com.lengedyun.easypoi.controller;


import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.export.base.ExportCommonService;
import cn.afterturn.easypoi.word.parse.excel.ExcelEntityParse;
import com.lengedyun.easypoi.bo.AffectedProvinceBo;
import com.lengedyun.easypoi.bo.OrderlyExectionStatusBo;
import com.lengedyun.easypoi.util.WordUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
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
public class ExportWordController extends ExportCommonService {

    /**
     * easypoi导出word
     */
    @GetMapping("word")
    public void easyExportWord1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String templatePath =  "src/main/resources/templates/test.docx"; //模板路径
        Map<String, Object> map = new HashMap();
        map.put("name", "zjy");
        map.put("age", "水电费");
        map.put("like", "book");
        map.put("fileName", "testwod");

        List<Map<String, Object>> maplist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("aa", "aa" + i);
            objectMap.put("bb", "水电费" + i);
            objectMap.put("cc", "水电费" + i);
            objectMap.put("dd", "dd" + i);
            maplist.add(objectMap);
        }
        map.put("userlist",maplist);
        map.put("strList",maplist);

        String temDir="D:/out/"; ;//生成临时文件存放地址
        //生成文件名
        Long time = System.currentTimeMillis();
        // 生成的word格式
        String formatSuffix = ".docx";
        // 拼接后的文件名
        String fileName = time + formatSuffix;//文件名  带后缀
        //导出word
        WordUtil.exportWord(templatePath, map, request, response);
    }

    @GetMapping(value = "/exportWord")
    public void exportWord(HttpServletRequest request, HttpServletResponse response) {
        String templatePath = "D:/daily_template.docx";
        if (StringUtils.isEmpty(templatePath)) {
            throw new RuntimeException("please config word.templatePath in yml");
        }
        Map map = this.getDemoData();

        //导出word
        WordUtil.exportWord(templatePath, map, request, response);
    }

    private Map<String, Object> getDemoData() {
        List<Object> list1 = new ArrayList<>();
        AffectedProvinceBo entity1 = new AffectedProvinceBo();
        entity1.setCompany("浙江");
        entity1.setAffectedHousehold(536.0);

        AffectedProvinceBo entity2 = new AffectedProvinceBo();
        entity2.setCompany("河南");
        entity2.setAffectedHousehold(303.5);

        AffectedProvinceBo entity3= new AffectedProvinceBo();
        entity3.setCompany("江西");
        entity3.setAffectedHousehold(140.5);

        AffectedProvinceBo entity4 = new AffectedProvinceBo();
        entity4.setCompany("青海");
        entity4.setAffectedHousehold(59.4);

        AffectedProvinceBo entity5 = new AffectedProvinceBo();
        entity5.setCompany("福建");
        entity5.setAffectedHousehold(56.1);

        list1.add(entity1);
        list1.add(entity2);
        list1.add(entity3);
        list1.add(entity4);
        list1.add(entity5);


        List<Object> list2 = new ArrayList<>();
        AffectedProvinceBo en1 = new AffectedProvinceBo();
        en1.setCompany("浙江");
        en1.setAffectedHousehold(450);

        AffectedProvinceBo en2 = new AffectedProvinceBo();
        en2.setCompany("江西");
        en2.setAffectedHousehold(130);

        AffectedProvinceBo en3= new AffectedProvinceBo();
        en3.setCompany("福建");
        en3.setAffectedHousehold(33);

        list2.add(en1);
        list2.add(en2);
        list2.add(en3);

        ArrayList<OrderlyExectionStatusBo> list3 = new ArrayList<>();
        OrderlyExectionStatusBo exe1 = new OrderlyExectionStatusBo("浙江","01",6310.0,500.0,"00：00-06：00 06：00-11：00",26482,536.0,0,0.0,333.1,"62.1%",8700.0,"107.2%");
        OrderlyExectionStatusBo exe2 = new OrderlyExectionStatusBo("河南","02",4107.0,250.0,"00:00-24:00",2382,140.5,0,0.0,209.9,"69.2%",5012.4,"121.4%");
        OrderlyExectionStatusBo exe3 = new OrderlyExectionStatusBo("江西","03",1826.5,170.0,"16:30-20:00",1798,303.5,0,0.0,129.3,"92.0%",432.5,"82.6%");

        list3.add(exe1);
        list3.add(exe2);
        list3.add(exe3);

        Map<String, Object> testMap = new HashMap<>();
        testMap.put("today","2021年10月31日");
        testMap.put("yday", "2021年10月30日");
        testMap.put("dbyday", "2021年10月29日");
        testMap.put("ydayProvinceNum", "5");
        testMap.put("ydayMaxPowerLoad", "1095.5");
        testMap.put("reducePowerLoad", "262.1");
        testMap.put("highEnergyIndustryLimitLoad", "797.7");
        testMap.put("highEnergyIndustryLoadRate", "71.9%");
        testMap.put("ydayProvince", "河南、山东" );

        testMap.put("totalAffectedHousehold", "33173");
        testMap.put("orderlyExectionStatus", list3);
        testMap.put("todayProvinceNumber", "3");
        testMap.put("todayProvince", "河南、山东");

        return testMap;
    }

}



package com.poi.data;

import com.alibaba.fastjson.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class ExcelExportTest {

    public static void main(String[] args) throws IOException {
        // 模拟10W条数据
        int count = 1000000;
        JSONArray studentArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            Person s = new Person();
            s.setName("POI" + i);
            s.setAge(i);
            s.setBirthday(new Date());
            s.setHeight(i);
            s.setWeight(i);
            s.setSex(i % 2 == 0 ? false : true);
            studentArray.add(s);
        }

        ArrayList<LinkedHashMap> titleList = new ArrayList<LinkedHashMap>();
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
        titleMap.put("title1","POI导出大数据量Excel Demo");
        titleMap.put("title2","https://github.com/550690513");
        LinkedHashMap<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("name", "姓名");
        headMap.put("age", "年龄");
        headMap.put("birthday", "生日");
        headMap.put("height", "身高");
        headMap.put("weight", "体重");
        headMap.put("sex", "性别");
        titleList.add(titleMap);
        titleList.add(headMap);



        File file = new File("ExcelExportDemo/");
        if (!file.exists()) {
            // 创建该文件夹目录
            file.mkdir();
        }

        long startTime = System.currentTimeMillis();

        try(OutputStream os = new FileOutputStream(file.getAbsolutePath() + "/" + startTime + ".xlsx")) {
            // .xlsx格式
            System.out.println("正在导出xlsx...");
            ExcelUtils.exportExcel(titleList, studentArray, os);
            System.out.println("导出完成...共" + count + "条数据,用时" + (System.currentTimeMillis() - startTime) + "ms");
            System.out.println("文件路径：" + file.getAbsolutePath() + "/" + startTime + ".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

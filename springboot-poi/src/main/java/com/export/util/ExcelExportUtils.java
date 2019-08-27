package com.export.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class ExcelExportUtils {
    public static void jdbcex(boolean isClose) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SQLException, IOException {

        // 输出文件
        String xlsFile = "1_test_export.xlsx";
        // 内存中只创建100个对象，写临时文件，当超过100条，就将内存中不用的对象释放。
        Workbook wb = new SXSSFWorkbook(100);
        // 工作表对象
        Sheet sheet = null;
        // 行对象
        Row nRow;
        // 列对象
        Cell nCell;

        long queryStart = System.currentTimeMillis();
        // 使用jdbc链接数据库
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3308/xinput?characterEncoding=UTF-8";
        String user = "root";
        String password = "123456";
        // 获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // 100万测试数据
        String sql = "select * from lis_detail limit 1000000";
        ResultSet rs = stmt.executeQuery(sql);

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("queryEnd : " + (System.currentTimeMillis() - queryStart) + " ms");
        // 开始时间
        long startTime = System.currentTimeMillis();
        System.out.println("strat execute time: " + startTime);

        // 总行号
        int rowNo = 0;
        // 页行号
        int pageRowNo = 0;

        while (rs.next()) {
            // 打印300000条后切换到下个工作表，可根据需要自行拓展，2百万，3百万...数据一样操作，只要不超过1048576就可以
            if (rowNo % 300000 == 0) {
                System.out.println("Current Sheet:" + rowNo / 300000);
                // 建立新的sheet对象
                sheet = wb.createSheet("我的第" + (rowNo / 300000) + "个工作簿");
                // 动态指定当前的工作表
                sheet = wb.getSheetAt(rowNo / 300000);
                // 每当新建了工作表就将当前工作表的行号重置为0
                pageRowNo = 0;
            }
            rowNo++;
            // 新建行对象
            nRow = sheet.createRow(pageRowNo++);
            // 打印每行，每行有6列数据   rsmd.getColumnCount()==6 --- 列属性的个数
            for (int j = 0; j < rsmd.getColumnCount(); j++) {
                nCell = nRow.createCell(j);
                nCell.setCellValue(rs.getString(j + 1));
            }

            if (rowNo % 10000 == 0) {
                System.out.println("row no: " + rowNo);
            }
            // 休息一下，防止对CPU占用，其实影响不大
            //  Thread.sleep(1);
        }

        // 处理完成时间
        long finishedTime = System.currentTimeMillis();
        System.out.println("finished execute  time: " + (finishedTime - startTime) / 1000 + "s");

        FileOutputStream fOut = new FileOutputStream(xlsFile);
        wb.write(fOut);
        // 刷新缓冲区
        fOut.flush();
        fOut.close();

        // 写文件时间
        long stopTime = System.currentTimeMillis();
        System.out.println("write xlsx file time: " + (stopTime - startTime) / 1000 + "m");

        // 执行关闭流的操作
        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void testExcport() throws ClassNotFoundException, SQLException, InstantiationException, IOException, IllegalAccessException {
        ExcelExportUtils.jdbcex(true);
    }
}

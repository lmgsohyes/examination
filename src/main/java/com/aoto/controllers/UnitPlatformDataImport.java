package com.aoto.controllers;

import com.aoto.util.DBToolkit;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;

/**
 * 统一平台数据导入
 */

@Controller
public class UnitPlatformDataImport {

    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/sysmenuimp", method = RequestMethod.GET)
    @ResponseBody
    public Object impSysMenu(){
        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            //读取文件
            File inputFile = new File("D:\\unitplatform_data\\sys_menu20200708.xlsx");

            FileInputStream in = new FileInputStream(inputFile);

            //解析excel
            XSSFWorkbook wb = new XSSFWorkbook(in);
            //获取第一个表格
            Sheet sheet = wb.getSheetAt(0);
            //获取最后行数
            int rowCount = sheet.getLastRowNum();

            //遍历行
            for (int i = 0; i <= rowCount; i++){
                Row row = sheet.getRow(i);
                int index = 0;
                String menuId = converCellValue(row.getCell(index++));
                String menuName =converCellValue(row.getCell(index++));
                String menuUrl = converCellValue(row.getCell(index++));
                String icon = converCellValue(row.getCell(index++));
                String parentId = converCellValue(row.getCell(index++));
                String funId = converCellValue(row.getCell(index++));
                String sortNum =converCellValue(row.getCell(index++));
                String levelNum =converCellValue(row.getCell(index++));
                levelNum = (Integer.parseInt(levelNum)+1)+"";
                String delete = converCellValue(row.getCell(index++));
                String createBy =converCellValue(row.getCell(index++));
                String updateBy = converCellValue(row.getCell(index++));
                System.out.println("行号："+i+" menuName:"+menuName+" menuId:"+menuId+" menuParentId:"+parentId+" createBy:"+createBy);

                //执行数据插入
                String sql = "insert into sys_menu_opt (MENU_ID, MENU_NAME, MENU_URL, ICON, PARENT_ID, FUN_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)" +
                        "values ("+menuId+", '"+menuName+"', '"+menuUrl+"', '"+icon+"', "+parentId+", "+funId+", "+sortNum+", "+levelNum+", "+delete+", "+createBy+", now(), "+updateBy+", now())";
                System.out.println("执行的sql语句："+sql);
               boolean execResult =  DBToolkit.executeSQL(conn,sql);
                System.out.println("执行结果："+execResult);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                DBToolkit.closeConnection(conn);
            }
        }
        return  null;
    }

    @RequestMapping(value = "/sysfunimp", method = RequestMethod.GET)
    @ResponseBody
    public Object impSysFunc(){
        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            //读取文件
            File inputFile = new File("D:\\unitplatform_data\\znbk_sys_fun.xlsx");

            FileInputStream in = new FileInputStream(inputFile);

            //解析excel
            XSSFWorkbook wb = new XSSFWorkbook(in);
            //获取第一个表格
            Sheet sheet = wb.getSheetAt(0);
            //获取最后行数
            int rowCount = sheet.getLastRowNum();

            //遍历行
            for (int i = 0; i <= rowCount; i++){
                Row row = sheet.getRow(i);
                int index = 0;
                String funId = converCellValue(row.getCell(index++));
                //播控系统前面加12
                funId = "12"+funId;
                String funName =converCellValue(row.getCell(index++));
                String parentId = converCellValue(row.getCell(index++));
                if (!"1".equals(parentId)){
                    parentId = "12"+parentId;
                }
                String sortNum =converCellValue(row.getCell(index++));
                String levelNum =converCellValue(row.getCell(index++));
                levelNum = (Integer.parseInt(levelNum)+1)+"";
                String delete = converCellValue(row.getCell(index++));
                String createBy =converCellValue(row.getCell(index++));
                String updateBy = converCellValue(row.getCell(index++));
                System.out.println("行号："+i+" funName:"+funName+" funId:"+funId+" menuParentId:"+parentId+" createBy:"+createBy);

                //执行数据插入
                String sql = "insert into sys_fun_opt (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)" +
                        "values ("+funId+", '"+funName+"', "+parentId+", "+sortNum+", "+levelNum+", "+delete+", "+createBy+", now(), "+updateBy+", now())";
                System.out.println("执行的sql语句："+sql);
                boolean execResult =  DBToolkit.executeSQL(conn,sql);
                System.out.println("执行结果："+execResult);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                DBToolkit.closeConnection(conn);
            }
        }
        return  null;
    }

    /**
     * 积分魔盒功能导入
     * @return
     */
    @RequestMapping(value = "/sysfunjfmohimp", method = RequestMethod.GET)
    @ResponseBody
    public Object impSysJfmhFunc(){
        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            //读取文件
            File inputFile = new File("D:\\unitplatform_data\\sys_fun_jfmh.xlsx");

            FileInputStream in = new FileInputStream(inputFile);

            //解析excel
            XSSFWorkbook wb = new XSSFWorkbook(in);
            //获取第一个表格
            Sheet sheet = wb.getSheetAt(0);
            //获取最后行数
            int rowCount = sheet.getLastRowNum();

            //遍历行
            for (int i = 1; i <= rowCount; i++){
                Row row = sheet.getRow(i);
                int index = 0;
                String funId = converCellValue(row.getCell(index++));
                //积分魔盒系统
                if (!"1401".equals(funId)) {
                    funId = "14"+funId;
                }
                String funName =converCellValue(row.getCell(index++));
                String parentId = converCellValue(row.getCell(index++));
                if (!"1".equals(parentId) && !"1401".equals(parentId)){
                    parentId = "14"+parentId;
                }
                String sortNum =converCellValue(row.getCell(index++));
                String levelNum =converCellValue(row.getCell(index++));
                levelNum = (Integer.parseInt(levelNum)+1)+"";
                String delete = converCellValue(row.getCell(index++));
                String createBy =converCellValue(row.getCell(index++));
                String updateBy = converCellValue(row.getCell(index++));
                System.out.println("行号："+i+" funName:"+funName+" funId:"+funId+" menuParentId:"+parentId+" createBy:"+createBy);

                //执行数据插入
                String sql = "insert into sys_fun_convert (FUN_ID, FUN_NAME, PARENT_ID, SORT_NUM, LEVEL_NUM, DELETED, CREATED_BY, CREATED_DATE, LAST_UPDATED_BY, LAST_UPDATED_DATE)" +
                        "values ("+funId+", '"+funName+"', "+parentId+", "+sortNum+", "+levelNum+", "+delete+", "+createBy+", now(), "+updateBy+", now())";
                System.out.println("执行的sql语句："+sql);
                boolean execResult =  DBToolkit.executeSQL(conn,sql);
                System.out.println("执行结果："+execResult);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                DBToolkit.closeConnection(conn);
            }
        }
        return  null;
    }


    /**
     * 获取cell转换后的字符串的值
     * @param cell
     * @return
     */
    private String converCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        int cellType = cell.getCellType();

        switch (cellType) {
            case Cell.CELL_TYPE_STRING: //字符串类型
                cellValue= cell.getStringCellValue().trim();
                cellValue= StringUtils.isEmpty(cellValue) ? "" : cellValue;
                break;
            case Cell.CELL_TYPE_BOOLEAN:  //布尔类型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC: //数值类型
                    cellValue =String.valueOf(new Double(cell.getNumericCellValue()).intValue());
                break;
            default: //其它类型，取空串吧
                cellValue = "";
                break;
        }
        return cellValue;
        }



    }




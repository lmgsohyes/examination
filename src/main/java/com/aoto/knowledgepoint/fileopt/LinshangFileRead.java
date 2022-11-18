package com.aoto.knowledgepoint.fileopt;


import com.aoto.util.DBToolkit;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * 临时银行日志分析
 * @author Administrator
 *
 */
public class LinshangFileRead {


    public static void main(String[] args) {

        //分析泰安银行的设备注册日志
//        ta_exceptionTimeAnsy();
        ta_errorAnsy();

    }

    private static void ta_errorAnsy() {
        JsonNode rootNode = null;
        List devices = new ArrayList();
        try {
            //读取文件
//            File inputFile = new File("D:\\logs_fenxi\\iqmslogs\\iqmslogs\\error\\2021-01-12\\error-log.log");
            File inputFile = new File("D:\\logs_fenxi\\iqmslogs\\iqmslogs\\error\\2021-01-07\\error-log.log");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "UTF-8"), 10 * 1024 * 1024);//10M缓存
            int count = 0;
            while (in.ready()) {
                String line = in.readLine();
                //如果是流水数据上报的字样，我们就读取这一样
                if (line.contains("请求的数据内容为") && line.contains("D001")) {

                    System.out.println(line);

                    //获取时间：
                    String dealTime = line.substring(0,23);
                    String deviceCode = line.substring(line.lastIndexOf("deviceId")+11,line.lastIndexOf("deviceId")+20);
                    System.out.println("请求时间："+dealTime+" 请求地址："+deviceCode);

                    //插入到数据库中：
                    String inserSql = "insert into testboc_noerror values ('"+dealTime+"','"+deviceCode+"')";
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.210.249:1521:ORCL", "MIPS_SCRB", "MIPS_SCRB");
                    boolean result = DBToolkit.executeSQL(con,inserSql);
                    DBToolkit.closeConnection(con);

                    //System.out.println(dealTime);
                    //System.out.println(dealIp);
                   // System.out.println(deviceId);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 异常时间点日志分析
     */
    private static void ta_exceptionTimeAnsy() {
        JsonNode rootNode = null;

        List devices = new ArrayList();

        try {
            //读取文件
            File inputFile = new File("D:\\logs_fenxi\\iqmslogs\\iqmslogs\\error\\2020-12-22\\error-log.log");


            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), 10 * 1024 * 1024);//10M缓存
            int count = 0;
            while (in.ready()) {
                String line = in.readLine();
                //如果是流水数据上报的字样，我们就读取这一样
                if (line.contains("客户端请求的ip地址：")) {
                    String deviceIp = line.substring(line.indexOf("客户端请求的ip地址：")+12);
                    //System.out.println(deviceIp);
                    // System.out.println(deviceId);
                    if (devices.contains(deviceIp)){
                        continue;
                    }

                    devices.add(deviceIp);
                    System.out.println(deviceIp);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

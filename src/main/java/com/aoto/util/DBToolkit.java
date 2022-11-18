package com.aoto.util;

import org.apache.log4j.Logger;


import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
* JDBC工具类
*
* @author zhuhailiang
*/
public class DBToolkit {

        /**
         * 在一个数据库连接上执行一个静态SQL语句查询
         *
         * @param conn            数据库连接
         * @param staticSql 静态SQL语句字符串
         * @return 返回查询结果集ResultSet对象
         */
        public static ResultSet executeQuery(Connection conn, String staticSql) {
                ResultSet rs = null;
                try {
                        //创建执行SQL的对象
                        Statement stmt = conn.createStatement();
                        //执行SQL，并获取返回结果
                        rs = stmt.executeQuery(staticSql);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return rs;
        }

        /**
         * 在一个数据库连接上执行一个静态SQL语句
         *
         * @param conn            数据库连接
         * @param staticSql 静态SQL语句字符串
         */
        public static boolean executeSQL(Connection conn, String staticSql) {
                try {
                        //创建执行SQL的对象
                        Statement stmt = conn.createStatement();
                        //执行SQL，并获取返回结果
                       boolean execResult = stmt.execute(staticSql);
                        return execResult;
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return false;
        }

        /**
         * 在一个数据库连接上执行一批静态SQL语句
         *
         * @param conn        数据库连接
         * @param sqlList 静态SQL语句字符串集合
         */
        public static void executeBatchSQL(Connection conn, List<String> sqlList) {
                try {
                        //创建执行SQL的对象
                        Statement stmt = conn.createStatement();
                        for (String sql : sqlList) {
                                stmt.addBatch(sql);
                        }
                        //执行SQL，并获取返回结果
                        stmt.executeBatch();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public static void closeConnection(Connection conn) {
                if (conn == null) return;
                try {
                        if (!conn.isClosed()) {
                                //关闭数据库连接
                                conn.close();
                        }
                } catch (SQLException e) {
                       e.printStackTrace();
                }
        }
}

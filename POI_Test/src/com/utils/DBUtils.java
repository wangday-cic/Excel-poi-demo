/**
 * Copyright 2006-2019 Mazda Motor Co. All Rights Reserved.
 *
 * This software is the proprietary information of Mazda Motor Co.
 * Use is subject to license terms.
 */

package com.utils;

import java.sql.*;
/**
*
* description
*
*
* @author 会社名:, 名前(ローマ字):
*
*/
public class DBUtils {
    
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "root";
    private static final String password = "root";

    // 1 加载驱动
    static {
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
    }

    // 2 获取连接
    public static Connection getConn() throws SQLException {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
    }
}

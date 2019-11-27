package org.skywalker.mapper;

import java.sql.*;

public class DaoBase implements Dao {
    public static final String URL = "jdbc:sqlserver://127.0.0.1:1433;";
    public static final String DB = "douban";
    public static final String USER = "sa";
    public static final String PASSWORD = "sql";

    public Connection conn = null;
    public PreparedStatement ps = null;
    public String sql = null;
    public ResultSet rs = null;
    public int ret = 0;

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL + "databaseName=" + DB,
                    USER, PASSWORD);
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return conn;
    }

    public void endExecution() {
        try {
            if (conn != null) { conn.close(); }
            if (ps != null) { ps.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void endExecutionRet() {
        try {
            if (conn != null) { conn.close(); }
            if (ps != null) { ps.close(); }
            if (rs != null) { rs.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

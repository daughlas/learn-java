package tech.lvjiawen.jdbc.utils;

import java.sql.*;

/**
 * JDBC 的工具类
 * @author daughlas@gmail.com
 */
public class JDBCUtils {
    private static final String driverClass;
    private static final String url;
    private static final String username;
    private static final String password;

    static  {
        driverClass = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306";
        username = "root";
        password  = "abc2553947";
    }

    /**
     * 注册驱动的方法
     */
    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(driverClass);
    }

    /**
     * 获得连接
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        loadDriver();
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * 资源释放
     */
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}

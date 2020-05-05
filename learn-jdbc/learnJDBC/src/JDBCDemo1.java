
import org.junit.Test;

import java.sql.*;

public class JDBCDemo1 {
    @Test
    public void demo1() throws SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection conn = null;

        try {
            // 1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获得连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbctest",
                    "root",
                    "abc2553947"
            );
            // 创建执行 SQL 语句的对象，并且执行 SQL
            String sql = "SELECT * FROM user";
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);

            while(resultSet.next()) {
                int uid = resultSet.getInt("uid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                System.out.println(uid + " " + username + " " + password + " " + name);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // 垃圾回收机机制会更快的回收
                resultSet = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null; // 垃圾回收机机制会更快的回收
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null; // 垃圾回收机机制会更快的回收
            }
        }
    }
}

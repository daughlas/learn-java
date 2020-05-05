package tech.lvjiawen.jdbc.demo;

import org.junit.Test;
import tech.lvjiawen.jdbc.utils.JDBCUtils;

import java.sql.*;

public class JDBCDemo4 {

    @Test
    public void demo1() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user";
            int num = stmt.executeUpdate(sql);
            if (num >  0) {
                System.out.println("查询成功");
            } else {
                System.out.println("查询失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(stmt, conn);
        }
    }

    @Test
    public void demo2() {
//        boolean flag = JDBCDemo4.login("aaa' or '1=1", "123123");
//        boolean flag = JDBCDemo4.login("aaa", "123123");
        boolean flag = JDBCDemo4.login2("aaa' or '1=1", "123123");
//        boolean flag = JDBCDemo4.login("aaa' or '1=1", "123123");
        if (flag == true) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登陆失败！");
        }
    }

    /**
     * 避免 SQL 注入
     * @param username
     * @param password
     * @return
     */
    public static boolean login(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            // 编写 SQL
            String sql = "select * from user WHERE username = '"+username+"' and password = '"+password+"'";
            // 执行sql 语句
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return flag;
    }

    /**
     * 避免 SQL 注入
     * @param username
     * @param password
     * @return
     */
    public static boolean login2(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            conn = JDBCUtils.getConnection();
            // 编写 SQL
            String sql = "select * from user WHERE username = ? and password = ?";
            // 预编译 SQL
            pstmt = conn.prepareStatement(sql);
            // 设置具体参数
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            // 执行sql 语句
            rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstmt, conn);
        }
        return flag;
    }

}

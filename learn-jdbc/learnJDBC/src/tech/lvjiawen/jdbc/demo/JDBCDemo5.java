package tech.lvjiawen.jdbc.demo;

import org.junit.Test;
import tech.lvjiawen.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDemo5 {
    @Test
    /**
     * 保存数据
     */
    public void save() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获得连接
            conn = JDBCUtils.getConnection();

            // 编写SQL
            String sql = "INSERT INTO user VALUES(null, ?, ?, ?)";

            // 预编译 SQL
            pstmt = conn.prepareStatement(sql);

            // 设置具体的参数
            pstmt.setString(1, "eee");
            pstmt.setString(2, "555");
            pstmt.setString(3, "田七");

            // 执行 SQL
            int num = pstmt.executeUpdate();

            if (num > 0) {
                System.out.println("保存成功");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.release(pstmt, conn);
        }
    }

    @Test
    /**
     * 编辑数据
     */
    public void edit() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获得连接
            conn = JDBCUtils.getConnection();

            // 编写SQL
            String sql = "UPDATE user SET name = ?, password = ?  WHERE uid = ?";

            // 预编译 SQL
            pstmt = conn.prepareStatement(sql);

            // 设置具体的参数
            pstmt.setString(1, "田七_changed_2");
            pstmt.setString(2, "555_changed_2");
            pstmt.setInt(3, 5);

            // 执行 SQL
            int num = pstmt.executeUpdate();

            if (num > 0) {
                System.out.println("保存成功");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.release(pstmt, conn);
        }
    }

    @Test
    /**
     * 删除数据
     */
    public void delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获得连接
            conn = JDBCUtils.getConnection();

            // 编写SQL
            String sql = "DELETE FROM user WHERE uid = ?";

            // 预编译 SQL
            pstmt = conn.prepareStatement(sql);

            // 设置具体的参数
            pstmt.setInt(1, 5);

            // 执行 SQL
            int num = pstmt.executeUpdate();

            if (num > 0) {
                System.out.println("删除成功");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.release(pstmt, conn);
        }
    }

    @Test
    /**
     * 查询数据
     */
    public void query() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "SELECT * FROM user";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("uid") + "   " + rs.getString("username")
                        + "   " + rs.getString("password") + "   " + rs.getString("name")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.release(rs, pstmt, conn);
        }
    }
}

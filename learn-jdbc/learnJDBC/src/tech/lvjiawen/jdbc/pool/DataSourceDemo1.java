package tech.lvjiawen.jdbc.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import tech.lvjiawen.jdbc.utils.JDBCUtils;
import tech.lvjiawen.jdbc.utils.JDBCUtils2;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 连接池的测试类
 */
public class DataSourceDemo1 {
    @Test
    /**
     * 手动设置连接池
     */
    public void demo1() throws PropertyVetoException {



        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 创建连接池
            ComboPooledDataSource dataSoure = new ComboPooledDataSource();
            // 设置连接池相关参数
            dataSoure.setDriverClass("com.mysql.jdbc.Driver");
            dataSoure.setJdbcUrl("jdbc:mysql://localhost:3306/jdbctest");
            dataSoure.setUser("lvjiawen");
            dataSoure.setPassword("lvjiawen");
            dataSoure.setMaxPoolSize(20);
            dataSoure.setInitialPoolSize(3);
            // 获得连接
            // 改进
            conn = dataSoure.getConnection();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("uid") + "   " + rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstmt, conn);
        }
    }

    @Test
    /**
     * 使用配置文件的方式使用 c3p0；
     */
    public void demo2() {
        // 获得连接
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 获得连接
            conn = JDBCUtils2.getConnection();

            String sql = "select * from user";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("username"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
    }
}

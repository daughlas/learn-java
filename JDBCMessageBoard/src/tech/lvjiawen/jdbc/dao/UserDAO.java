package tech.lvjiawen.jdbc.dao;

import tech.lvjiawen.jdbc.bean.User;
import tech.lvjiawen.jdbc.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户 Bean，失败返回 null
     */
    public User login(String username, String password) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM user where username = ? AND password = ?";
        PreparedStatement pstmt  = null;
        ResultSet rs = null;
        User user  = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setRealName(rs.getString("real_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("登录失败");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, pstmt, conn);
        }
        return user;
    }

    public User getUserById(Long id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM user where id = ?";
        PreparedStatement pstmt  = null;
        ResultSet rs = null;
        User user  = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setRealName(rs.getString("real_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("查询用户信息失败");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, pstmt, conn);
        }
        return user;
    }

    public boolean updateUser(User user) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "UPDATE user SET username = ?, password = ?, real_name = ?, birthday = ?, phone = ?, address = ? WHERE id = ?";
        PreparedStatement pstmt  = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRealName());
            pstmt.setDate(4, new Date(user.getBirthday().getTime()));
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getAddress());
            pstmt.setLong(7, user.getId());
            pstmt.execute();
        } catch (Exception e) {
            System.out.println("更新用户信息失败");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, pstmt, conn);
        }
        return true;
    }
}

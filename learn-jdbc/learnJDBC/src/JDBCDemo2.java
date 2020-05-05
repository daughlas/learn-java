
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCDemo2 {
    @Test
    public void demoInsert() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "abc2553947");

            stmt = conn.createStatement();

            String sql = "INSERT INTO user values(null, 'eee', '555', '田七')";

            int i = stmt.executeUpdate(sql);
            if (i > 0) {
                System.out.println("保存成功");
            } else {
                System.out.println("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    @Test
    public void demoUpdate() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "abc2553947");

            stmt = conn.createStatement();

            String sql = "UPDATE user SET username = 'fff', password = '666', name='王八' WHERE uid = 5 ";;

            int i = stmt.executeUpdate(sql);
            if (i > 0) {
                System.out.println("保存成功");
            } else {
                System.out.println("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    @Test
    public void demoDelete() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "abc2553947");

            stmt = conn.createStatement();

            String sql = "DELETE FROM user where uid = 6 OR uid = 5";;

            int i = stmt.executeUpdate(sql);
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    @Test
    public void demoQuery() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "abc2553947");

            stmt = conn.createStatement();

            String sql = "SELECT * FROM user where uid = 2";

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println(rs.getInt("uid") + "   " + rs.getString("username"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
}

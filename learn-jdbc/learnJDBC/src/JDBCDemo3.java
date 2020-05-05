
import org.junit.Test;
import tech.lvjiawen.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCDemo3{
    @Test
    public void demo1() {

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUtils.getConnection();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
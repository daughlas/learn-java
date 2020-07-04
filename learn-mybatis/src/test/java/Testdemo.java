import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import tech.lvjiawen.learnmybatis.entity.Users;
import tech.lvjiawen.learnmybatis.utils.SqlSessionFactoryUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Testdemo {
    @Test
    public void TestDemo1() throws IOException {
        // 初始化 mybatis 配置环境
        SqlSessionFactoryUtils.initSqlSessionFactory();
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();

        List<Users> ulist = session.selectList("findAll");

        for (Users user: ulist) {
            System.out.println(user);
        }

        session.close();
    }
}

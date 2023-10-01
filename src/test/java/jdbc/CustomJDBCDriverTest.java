package jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

/**
 * @ClassName jdbc.CustomJDBCDriverTest
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/29 21:52
 * @Version 0.0.1
 **/
public class CustomJDBCDriverTest {

    @Test
    public void testCustomJDBCDriverConnection() {
        try {
            // 加载并注册自定义JDBC驱动
            Class.forName("com.jdbc.CustomJDBCDriver"); // 替换为你的CustomJDBCDriver的完整类名

            // 使用DriverManager获取连接
            Connection connection = DriverManager.getConnection("jdbc:custom://localhost:8080");

            // 验证连接是否成功
            assertNotNull(connection);

            // 关闭连接
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

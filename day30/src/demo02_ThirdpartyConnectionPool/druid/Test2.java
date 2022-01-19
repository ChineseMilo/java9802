package demo02_ThirdpartyConnectionPool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import demo02_ThirdpartyConnectionPool.User;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();

        InputStream r = Test2.class.getClassLoader().getResourceAsStream("druid.properties");

        p.load(r);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(p);

        Connection connection = dataSource.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;
        while (resultSet.next()){

            user = new User(resultSet.getInt("id"),resultSet.getString("username"),
                    resultSet.getString("password"),resultSet.getString("nickname"));
        }

        JDBCUtils.release(resultSet,preparedStatement,connection);
        System.out.println(user);
    }
}

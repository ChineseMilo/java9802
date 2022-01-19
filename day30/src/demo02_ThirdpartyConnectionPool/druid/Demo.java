package demo02_ThirdpartyConnectionPool.druid;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import demo02_ThirdpartyConnectionPool.User;

import utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Demo {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/day29");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        dataSource.setInitialSize(5);

        DruidPooledConnection connection = dataSource.getConnection();
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

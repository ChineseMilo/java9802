package demo02_ThirdpartyConnectionPool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import demo02_ThirdpartyConnectionPool.User;
import utils.JDBCUtils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day29");

        dataSource.setUser("root");
        dataSource.setPassword("123456");

        dataSource.setInitialPoolSize(5);
        Connection connection = dataSource.getConnection();

        String sql = "select * from user where id = ?";
        PreparedStatement p = connection.prepareStatement(sql);

        p.setInt(1,1);

        ResultSet resultSet = p.executeQuery();
        User user = null;
        while (resultSet.next()){

            user = new User(resultSet.getInt("id"),resultSet.getString("username"),
                    resultSet.getString("password"),resultSet.getString("nickname"));
        }

        JDBCUtils.release(resultSet,p,connection);
        System.out.println(user);
    }
}

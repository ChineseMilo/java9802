package demo02_ThirdpartyConnectionPool.druid;

import demo02_ThirdpartyConnectionPool.User;
import utils.DruidUtils;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test3 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;
        while (resultSet.next()){

            user = new User(resultSet.getInt("id"),resultSet.getString("username"),
                    resultSet.getString("password"),resultSet.getString("nickname"));
        }

        DruidUtils.release(resultSet,preparedStatement,connection);
        System.out.println(user);
    }
}

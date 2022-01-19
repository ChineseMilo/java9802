package demo01_CustomConnectionPool;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1,1);
        ResultSet resultSet = p.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
            System.out.println(resultSet.getString("nickname"));
        }

        JDBCUtils.release(resultSet,p,connection);

    }
}

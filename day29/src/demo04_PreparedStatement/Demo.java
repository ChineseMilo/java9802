package demo04_PreparedStatement;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
    @Test
    public void insert() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into user values(null,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);


        ps.setString(1,"xxx");
        ps.setString(2,"654321");
        ps.setString(3,"wanbga");

        int i = ps.executeUpdate();

        JDBCUtils.release(null,ps,connection);



    }
    @Test
    public void select() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,1);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
            System.out.println(resultSet.getString("nickname"));
        }

        JDBCUtils.release(resultSet,ps,connection);

    }
}

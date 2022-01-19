package demo04_PreparedStatement;

import demo01_gettingStarted.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名：");
        String userName = sc.next();
        System.out.println("输入密码：");
        String passWord = sc.next();

        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,userName);
        ps.setString(2,passWord);

        ResultSet resultSet = ps.executeQuery();
        User user = null;
        while (resultSet.next()){
            user = new User(resultSet.getInt("id"),resultSet.getString("username"),
                    resultSet.getString("password"),resultSet.getString("nickname"));




        }


        JDBCUtils.release(resultSet,ps,connection);
        System.out.println(user);

        if (user == null){
            System.out.println("登录失败");
        }else {
            System.out.println("登录成功");
        }

    }
}

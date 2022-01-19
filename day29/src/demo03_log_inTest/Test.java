package demo03_log_inTest;

import demo01_gettingStarted.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();


        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名：");
        String userName = sc.next();
        System.out.println("输入密码：");
        String passWord = sc.next();

        String sql = "select * from user where username = '"+userName+"' and password = '"+passWord+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        User user = null;
        while (resultSet.next()){
            user = new User(resultSet.getInt("id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("nickname"));

        }


        JDBCUtils.release(resultSet,statement,connection);

        if(user == null){
            System.out.println("登录失败");
        }else {
            System.out.println("登录成功");
        }
    }
}

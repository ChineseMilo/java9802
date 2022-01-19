package demo01_gettingStarted;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/day29";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement = connection.createStatement();

        String sql = "select * from user";

        ResultSet resultSet = statement.executeQuery(sql);

        List<User> list = new ArrayList<User>();

        while(resultSet.next()){

            User user = new User(resultSet.getInt("id"),resultSet.getString("username"),
                    resultSet.getString("password"),resultSet.getString("nickname"));
            list.add(user);


        }

        if(resultSet != null){
            resultSet.close();
        }

        if (statement != null){
            statement.close();
        }

        if (connection != null){
            connection.close();
        }

        for (User user : list) {
            System.out.println(user);
        }
    }
}

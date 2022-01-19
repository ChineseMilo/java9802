package demo02_test;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.*;

public class Demo {

//    想day29数据库中的user表增加一条数据
    @Test
    public void insert() throws ClassNotFoundException, SQLException {
       /* Class.forName("com.mysql.jdbc.Driver");
//        获取连接
        String url = "jdbc:mysql://localhost:3306/day29";
        String userName = "root";
        String passWord = "123456";

        Connection connection = DriverManager.getConnection(url, userName, passWord);
//        创建执行sql对象
        Statement statement = connection.createStatement();
//        执行sql语句
        int i = statement.executeUpdate("insert into user values(null,'tq','332211','人才')");
        System.out.println(i);

        statement.close();
        connection.close();*/

        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into user values(null,'tq','332211','人才')";
        int i = statement.executeUpdate(sql);
        JDBCUtils.release(null,statement,connection);
    }
    @Test
    public void update() throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.jdbc.Driver");
//        获取连接
        String url = "jdbc:mysql://localhost:3306/day29";
        String userName = "root";
        String passWord = "123456";

        Connection connection = DriverManager.getConnection(url, userName, passWord);
//        创建执行sql对象
        Statement statement = connection.createStatement();
//        执行sql语句
        int i = statement.executeUpdate("update user set password = '1111111' where username = 'tq'");
        System.out.println(i);

        statement.close();
        connection.close();*/

        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = "update user set password = '1111111' where username = 'zs'";
        statement.executeUpdate(sql);
        JDBCUtils.release(null,statement,connection);
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
/*        Class.forName("com.mysql.jdbc.Driver");
//        获取连接
        String url = "jdbc:mysql://localhost:3306/day29";
        String userName = "root";
        String passWord = "123456";

        Connection connection = DriverManager.getConnection(url, userName, passWord);
//        创建执行sql对象
        Statement statement = connection.createStatement();
//        执行sql语句
        int i = statement.executeUpdate("delete from user where id = 5");
        System.out.println(i);

        statement.close();
        connection.close();*/

        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();

        String sql = "delete from user where id = 4";

        int i = statement.executeUpdate(sql);

        JDBCUtils.release(null,statement,connection);


    }

    @Test
    public void selectOne() throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.jdbc.Driver");
//        获取连接
        String url = "jdbc:mysql://localhost:3306/day29";
        String userName = "root";
        String passWord = "123456";

        Connection connection = DriverManager.getConnection(url, userName, passWord);
//        创建执行sql对象
        Statement statement = connection.createStatement();
//        执行sql语句
        ResultSet resultSet = statement.executeQuery("select * from user where id = 2");

        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
            System.out.println(resultSet.getString("nickname"));


        }

        resultSet.close();
        statement.close();
        connection.close();*/

        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from user where id = 2";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
            System.out.println(resultSet.getString("nickname"));


        }

        JDBCUtils.release(resultSet,statement,connection);


    }

}

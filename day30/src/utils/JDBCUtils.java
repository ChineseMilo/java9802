package utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;//加载驱动
    private static String url;//连接路径
    private static String username;//数据库用户名
    private static String password;
    static {

        try {
            //1.创建properties对象加载配置文件
            Properties pro = new Properties();

            //2.读取配置文件中的数据
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            pro.load(is);

            //给对象赋值，通过pro
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");

            //加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }





    }

    //封装获得连接的方法
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    //释放资源
    public static void release(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

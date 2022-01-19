package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DruidUtils {
    private static DataSource dataSource;
    static {

        try {
            Properties p = new Properties();

            InputStream r = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            p.load(r);

            dataSource = DruidDataSourceFactory.createDataSource(p);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection){
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

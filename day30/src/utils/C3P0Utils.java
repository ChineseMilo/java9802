package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Utils {
    private static ComboPooledDataSource COMBO_POOLED_DATA_SOURCE = new ComboPooledDataSource();

    public static Connection getConnection() throws SQLException {
        Connection connection = COMBO_POOLED_DATA_SOURCE.getConnection();
        return connection;

    }

    public static DataSource getDataSource(){
        return COMBO_POOLED_DATA_SOURCE;
    }

    public static void release(ResultSet resultSet, Statement statement,Connection connection){
        if(resultSet != null){
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

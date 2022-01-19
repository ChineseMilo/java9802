package demo04_customizeDBUtils.test;

import utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyQueryRunner {
    private DataSource dataSource;

    public MyQueryRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MyQueryRunner() {
    }


    public int update(String sql,Object...args) throws SQLException {
        if(dataSource == null){
            return -1;
        }

        if(sql == null){
            return -1;
        }

        Connection connection = dataSource.getConnection();

        PreparedStatement p = connection.prepareStatement(sql);

        ParameterMetaData pmd = p.getParameterMetaData();

        int count = pmd.getParameterCount();

        for (int i = 0; i < count; i++) {
            p.setObject(i+1,args[i]);
        }

        int i = p.executeUpdate();

        DruidUtils.release(null,p,connection);



        return i;
    }
}

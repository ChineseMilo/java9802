package demo04_customizeDBUtils;

import utils.DruidUtils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from user where id = ? and username = ?";
        PreparedStatement p = connection.prepareStatement(sql);
        ParameterMetaData pmd = p.getParameterMetaData();
        int count = pmd.getParameterCount();
        System.out.println("参数个数："+count);




    }
}

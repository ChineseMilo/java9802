package demo04_customizeDBUtils;

import utils.DruidUtils;

import java.sql.*;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Connection connection = DruidUtils.getConnection();
        String sql = "select * from user where id = ? and username = ?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1,1);
        p.setString(2,"zs");
        ResultSet resultSet = p.executeQuery();
        ResultSetMetaData rmd = resultSet.getMetaData();

        int count = rmd.getColumnCount();
        System.out.println("参数个数："+count);

        for (int i = 1; i <= count; i++) {
            System.out.println(rmd.getColumnName(i));
        }

        for (int i = 1; i <= count; i++) {
            System.out.println(rmd.getColumnTypeName(i));
        }

        for (int i = 1; i <= count; i++) {
            System.out.println(rmd.getColumnClassName(i));
        }
    }
}

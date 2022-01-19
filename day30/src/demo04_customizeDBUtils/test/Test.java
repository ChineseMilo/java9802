package demo04_customizeDBUtils.test;


import utils.DruidUtils;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        MyQueryRunner mqr = new MyQueryRunner(DruidUtils.getDataSource());
        int rows = mqr.update("insert into user values(null,?,?,?)", "aaaa", "aa11aa", "啊啊");

        System.out.println(rows);
    }
}

package demo01_CustomConnectionPool.advanced;


import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo {
    @Test
    public void select() throws SQLException {
        DataSource md = new MyDataSource();
        System.out.println("获取连接前："+ MyDataSource.getCount());

        Connection conn = md.getConnection();
        System.out.println("获取连接前后："+ MyDataSource.getCount());

        ((MyDataSource)md).addBack(conn);
        System.out.println("结束后："+ MyDataSource.getCount());
    }
}

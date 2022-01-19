package demo01_CustomConnectionPool.primary;

import org.junit.Test;

import java.sql.Connection;

public class Demo {

    @Test
    public void select(){
        MyDataSource md = new MyDataSource();
        System.out.println("获取连接前："+MyDataSource.getCount());

        Connection conn = md.getAbc();
        System.out.println("获取连接前后："+MyDataSource.getCount());

        md.addBack(conn);
        System.out.println("结束后："+MyDataSource.getCount());
    }


}

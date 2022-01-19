package primary;

import org.junit.Test;

import java.sql.Connection;

public class Demo {

    @Test
    public void select(){
        MyDateSource md = new MyDateSource();
        System.out.println("获取连接前："+MyDateSource.getCount());

        Connection conn = md.getAbc();
        System.out.println("获取连接前后："+MyDateSource.getCount());
    }


}

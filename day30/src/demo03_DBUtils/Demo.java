package demo03_DBUtils;

import demo02_ThirdpartyConnectionPool.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

public class Demo {
    @Test
    public void insert() throws Exception {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        int rows = qr.update("insert into user values(null,?,?,?)", "yyy", "yy11yy", "嘤嘤嘤");
        if(rows > 0){
            System.out.println("数据添加成功");
        }else {
            System.out.println("数据添加失败");
        }

        System.out.println(rows);


    }


    @Test
    public void select() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        System.out.println("-----------------------BeanHandler-------------------------");

        User user = qr.query("select * from user where id = ?", new BeanHandler<>(User.class),2);
        System.out.println(user);
        System.out.println("-----------------------BeanListHandler-------------------------");
        LinkedList<User> list = new LinkedList<>();
        List<User> users = qr.query("select * from user", new BeanListHandler<User>(User.class));
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("--------------------------MapHandler-----------------------");
        Map<String, Object> map = qr.query("select * from user where id = ?", new MapHandler(),2);
        for (String s : map.keySet()) {
            System.out.println(s+":"+map.get(s));
        }

        System.out.println("-------------------------MapListHandler------------------------");
        List<Map<String, Object>> maps = qr.query("select * from user", new MapListHandler());
        for (Map<String, Object> stringObjectMap : maps) {
            for (String s : stringObjectMap.keySet()) {
                System.out.println(s+":"+stringObjectMap.get(s));
            }
        }

        System.out.println("-----------------------ScalarHandler---------------------------");

        Long count = (long)qr.query("select count(*) from user", new ScalarHandler());
        System.out.println(count);

        System.out.println("-----------------------ArrayHandler---------------------------");
        Object[] array = qr.query("select * from user where id = ?", new ArrayHandler(), 2);
        System.out.println(Arrays.toString(array));

        System.out.println("-----------------------ArrayListHandler---------------------------");
        List<Object[]> list1 = qr.query("select * from user", new ArrayListHandler());
        for (Object[] objects : list1) {
            System.out.println(Arrays.toString(objects));
        }

    }
}

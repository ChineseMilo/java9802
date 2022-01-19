package demo01_CustomConnectionPool.primary;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyDataSource {
    private static LinkedList<Connection> pools = new LinkedList<>();
    static {
        for (int i = 0; i < 5; i++) {
            try {
                Connection connection = JDBCUtils.getConnection();
                pools.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getCount(){
        return pools.size();
    }

    public void addBack(Connection connection){
        pools.addLast(connection);
    }

    public Connection getAbc(){
        Connection connection = pools.removeFirst();
        return connection;
    }
}

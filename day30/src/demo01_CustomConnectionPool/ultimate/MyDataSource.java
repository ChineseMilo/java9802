package demo01_CustomConnectionPool.ultimate;

import utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {

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
//    归还连接池
    public void addBack(Connection connection){
        pools.addLast(connection);
    }

//    计算当前连接池的数量
    public static int getCount(){
        return pools.size();
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = pools.removeFirst();
        MyConnection mc = new MyConnection(connection,pools);
        return mc;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

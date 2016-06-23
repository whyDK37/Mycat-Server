package demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mycat
 */
public class TestClass3 {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        String jdbcdriver = "com.mysql.jdbc.Driver";
        String jdbcurl = "jdbc:mysql://127.0.0.1:8066/TESTDB?useUnicode=true&characterEncoding=utf-8";
        String username = "test";
        String password = "test";
        System.out.println("开始连接mysql:" + jdbcurl);
        Class.forName(jdbcdriver);
        Connection c = DriverManager.getConnection(jdbcurl, username, password);
        c.setAutoCommit(true);
        Statement st = c.createStatement();
        st.execute("delete from travelrecord ");
        st.close();
        c.close();

        System.out.println("OK......");
    }

}

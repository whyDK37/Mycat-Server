package demo.test;

import java.sql.*;

/**
 * @author mycat
 */
public class TestClass2 {

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
//        print("test jdbc ", st.execute("select count(*) from travelrecord "));
        for(int i =0;i<100;i++){
            st.execute("insert into travelrecord (id,user_id,traveldate,fee,days) values("+i+","+i+",0000-00-00,"+i+","+i+")");
        }
        st.close();
        c.close();

        System.out.println("OK......");
    }

}

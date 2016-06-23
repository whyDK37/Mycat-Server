package demo.test;

import org.junit.Test;

import java.sql.*;

/**
 * Created by New on 2016/6/23.
 */
public class EducircleTest {

    @Test
    public void testSelect() throws ClassNotFoundException, SQLException {
        String jdbcdriver = "com.mysql.jdbc.Driver";
        String jdbcurl = "jdbc:mysql://127.0.0.1:8066/TESTDB?useUnicode=true&characterEncoding=utf-8";
        String username = "test";
        String password = "test";
        System.out.println("开始连接mysql:" + jdbcurl);
        Class.forName(jdbcdriver);
        Connection c = DriverManager.getConnection(jdbcurl, username, password);
        Statement st = c.createStatement();
        print("test jdbc ", st.executeQuery("select * from edu_educircle order by eduCircleTopicID"));
        System.out.println("OK......");

        st.close();
        c.close();
    }

    @Test
    public void testSelectCount() throws ClassNotFoundException, SQLException {
        String jdbcdriver = "com.mysql.jdbc.Driver";
        String jdbcurl = "jdbc:mysql://127.0.0.1:8066/TESTDB?useUnicode=true&characterEncoding=utf-8";
        String username = "test";
        String password = "test";
        System.out.println("开始连接mysql:" + jdbcurl);
        Class.forName(jdbcdriver);
        Connection c = DriverManager.getConnection(jdbcurl, username, password);
        Statement st = c.createStatement();
        print("test jdbc ", st.executeQuery("select count(*) from edu_educircle "));
        System.out.println("OK......");

        st.close();
        c.close();
    }

    private void print(String name, ResultSet res)
            throws SQLException {
        System.out.println(name);
        ResultSetMetaData meta = res.getMetaData();
        //System.out.println( "\t"+res.getRow()+"条记录");
        String str = "";
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            str += meta.getColumnName(i) + "   ";
            //System.out.println( meta.getColumnName(i)+"   ");
        }
        System.out.println("\t" + str);
        str = "";
        while (res.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                str += res.getString(i) + "   ";
            }
            System.out.println("\t" + str);
            str = "";
        }
    }

    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
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
        for(int i =0;i<1;i++){
            st.execute("insert into edu_educircle (username,eduCircleTopicID,createDate) values("+i+","+i+",0000-00-00)");
        }
        st.close();
        c.close();

        System.out.println("OK......");
    }

    @Test
    public void testDelete() throws ClassNotFoundException, SQLException {
        String jdbcdriver = "com.mysql.jdbc.Driver";
        String jdbcurl = "jdbc:mysql://127.0.0.1:8066/TESTDB?useUnicode=true&characterEncoding=utf-8";
        String username = "test";
        String password = "test";
        System.out.println("开始连接mysql:" + jdbcurl);
        Class.forName(jdbcdriver);
        Connection c = DriverManager.getConnection(jdbcurl, username, password);
        c.setAutoCommit(true);
        Statement st = c.createStatement();
        st.execute("delete from edu_educircle ");
        st.close();
        c.close();

        System.out.println("OK......");
    }
}

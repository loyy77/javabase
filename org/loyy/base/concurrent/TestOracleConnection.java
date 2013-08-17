package org.loyy.base.sort.org.loyy.base.Thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LiShiXi
 * Date: 13-3-31
 * Time: 下午8:32
 * 使用JDBC拦截Oracle数据库的例子，插入数据有进度显示和计时。
 * 要加入oracle 的jdbc driver
 */
public class TestOracleConnection {

    public static void main(String[] args) {
        TestOracleConnection toc = new TestOracleConnection();
        toc.insertData();
    }


    public void insertData() {

        Connection con = getConn();
        try {
            PreparedStatement ps = con.prepareStatement("insert into employee(eName) values(?)");
            Long starTime = new Date().getTime();

            for (int i = 0; i < 10000; i++) {
                ps.setString(1, "eName" + i);

                int curr = i / 100;
                int next = (i + 1) / 100;

                if (next > curr) {
                    System.out.print("\r");

                    printChar(curr + 1 + "% ", curr + 1);
                }
                ps.executeUpdate();
            }

            Long endTime = new Date().getTime();
            Long useTime = endTime - starTime;
            System.out.print("\n用时(毫秒):");
            System.out.print(useTime + "\n");

            SimpleDateFormat sdf = new SimpleDateFormat("ss秒ms毫秒");
            System.out.println(sdf.format(useTime));
            ;
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        for (int i = 0; i < 10000; i++) {

        }
    }

    public void printChar(String pre, int num) {
        System.out.print(pre);
        for (int i = 0; i < num; i++) {
            System.out.print("#");
        }
        for (int i = 0; i < 100 - num; i++) {
            System.out.print("_");
        }
    }


    public void createTable() {
        Connection con = getConn();
        try {
            int rst1 = con.prepareStatement("drop table employee").executeUpdate();
            int rst = con.prepareStatement("create table employee (id number(8) primary key ,ename varchar(10))").executeUpdate();
            System.out.println(rst > 0);
            System.out.println(rst);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


    public Connection getConn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "lsx", "lsx");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return null;
    }
}

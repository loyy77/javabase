package org.loyy.base.sort.org.loyy.base.Thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 13-3-25
 * Time: 上午10:42
 * 这是一个使用jdbc插入向derby数据库插入1w数据的小程序，并且会有进度显示。
 * 在打印进度功能实现时，遇到一些小问题，就是“\b" 在IDE环境下不起作用，该特殊字符的作用是退格，在命令行下是可行的。<br/>
 * 后来找到解决办法是用 "\r"回到行首，如果"\r"失效了，尝试 (char)13 代替\r

 */
public class thread1 implements Runnable {
    public static void main(String[] args) {
        Thread th1 = new Thread(new thread1());
        th1.start();
    }

    @Override
    public void run() {
        try {
            new thread1().genericData();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void genericData() throws SQLException {
        List<String> list = new ArrayList<String>();
        Connection con = getConn();
        int parant = 0;
        for (int i = 0; i < 10000; i++) {

            con.prepareStatement("insert into usr(uname) values('name" + i + "')").executeUpdate();

            int pre = i / 100;
            int next = (i + 1) / 100;
            parant = i / 100 + 1;   //凑足100

            if (next > pre) {
                /*每次打印“#”号之前都，把光标切换到行首，这样上次打印的信息就会被清除，然后再根据百分比打印对应数量的“#”号*/
                System.out.print("\r");
                print1(parant + "% ", parant);
            }

        }
    }

    public void print1(String pre, int j) {
        System.out.print(pre);
        for (int i = 0; i < j; i++) {
            System.out.print("#");
        }

        for (int i = 0; i < 100 - j; j++) {
            System.out.print("_");
        }
    }

    public void createTable() {
        Connection conn = getConn();
        try {
            PreparedStatement cmd = conn.prepareStatement("create table Usr(id int  generated always as identity ,uname varchar(10))");
            int i = cmd.executeUpdate();
            System.out.println(i);
            if (i > 0) {
                System.out.println("successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /*
    * 返回Connection对象
    * */
    public Connection getConn() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost/test;create=true");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}

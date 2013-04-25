package org.loyy.base.sort;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-25
 * Time: 上午12:11
 * To change this template use File | Settings | File Templates.
 */
public class DateFormatTest {

    public static void main(String[] args) {
        System.out.println(DateFormat.getInstance().format(new Date()));
    }
}

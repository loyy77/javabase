package org.loyy.base.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 新建一个写入对象
        BufferedWriter fw;
        // 指定路径和文件名。最后的true很重要，代表已存在的文件直接读取，不新建。
        try {
            fw = new BufferedWriter(new FileWriter("f:\\temp.txt",
                    true));
            // 新起一行
            fw.newLine();
            // 用append表示在文件最后增加。用write则会将整个文件重写
            fw.append("我是被写入txt的字符串");
            // 关闭进程
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

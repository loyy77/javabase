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
        // �½�һ��д�����
        BufferedWriter fw;
        // ָ��·�����ļ���������true����Ҫ�������Ѵ��ڵ��ļ�ֱ�Ӷ�ȡ�����½���
        try {
            fw = new BufferedWriter(new FileWriter("f:\\temp.txt",
                    true));
            // ����һ��
            fw.newLine();
            // ��append��ʾ���ļ�������ӡ���write��Ὣ�����ļ���д
            fw.append("���Ǳ�д��txt���ַ���");
            // �رս���
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

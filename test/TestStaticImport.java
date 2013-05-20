package test;

import java.math.BigInteger;

import static java.lang.System.nanoTime;
import static java.lang.System.out;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-11
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
public class TestStaticImport {
    public static void main(String[] args) {
        out.println("hello");
        out.println(nanoTime());
        out.println(StrictMath.PI);              //绝对精准的数学

        /*判断一个数是否是素数 （使用java自带类BigInteger*/
        BigInteger bigInteger = new BigInteger("13");
        System.out.println(bigInteger.isProbablePrime(13));



        /*把字符串转换为二进制形式*/
        byte[] bArr = new BigInteger("3").toByteArray();

        bArr = "new123-2".getBytes();
        out.println(bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            out.print(Integer.signum(bArr[i]));     //打印的一个数对应二进制位的符号，正号(0)或是负号(1)
            out.print(Integer.toBinaryString(bArr[i]));//转为二进制位形式
            out.print(" ");
        }
        out.println();
        for (int i = 1; i <= 10009; i++) {

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           /* 这是另外一种实现方式，随机生成0和1的序列**/
            out.print(i % 100 == 0 ? "\n" : (int) (Math.random() * 10 % 2));
        }


    }
}

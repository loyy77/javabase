package org.loyy.base.utils;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-22
 * Time: 下午1:26
 * To change this template use File | Settings | File Templates.
 */
public class RandomString {

    static Random random = new Random();

    public static void main(String[] args) {

        String s = getRandomString(256);
        System.out.println(s);
        //65 97
        System.out.println();
        for (int i = 65; i < 65 + 26; i++) {
            System.out.print(i + "," + (char) i + " ");
        }
        System.out.println();
        for (int i = 97; i < 97 + 26; i++) {
            System.out.print(i + "," + (char) i + " ");
        }
    }

    /**
     * 生成一个指定长度的随机字符串
     *
     * @param len 字符串长度
     * @return 随机字符串
     */
    public static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(randomLatter());
        }
        return sb.toString();
    }

    //                       随机字母
    public static char randomLatter() {


        char[] upper = new char[26];
        char[] lower = new char[26];
        char[] letters = new char[26 + 26];
        for (int j = 0; j < 26; j++) {
            upper[j] = (char) (65 + j);
            lower[j] = (char) (97 + j);
        }

        for (int j = 0; j < 52; j++) {
            if (j < 26) {
                letters[j] = upper[j];
            } else {
                letters[j] = lower[j - 26];
            }
        }


        int randomIdx = random.nextInt(52);

        return (char) letters[randomIdx];


    }
}

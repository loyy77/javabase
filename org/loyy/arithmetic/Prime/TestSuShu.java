package org.loyy.arithmetic.Prime;

public class TestSuShu {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 打印1-100之间的素数
        long begin = System.currentTimeMillis();
        boolean flag = true;
        for (int i = 2; i <= 100000; i++) {
            flag = true;
            //Math.sqrt(i)：算法优化，减少不必要的除法
            for (long j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i);
            }
        }

        System.out.println("\n第一次：" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        System.out.println("开始第二次");

        for (int i = 2; i < 100000; i++) {
            if (isPrime(i)) {
                System.out.print(i);
            }

        }

        System.out.println("\n第二次" + (System.currentTimeMillis() - begin));


    }

    public static boolean isPrime(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {

                return false;

            }
        }
        return true;
    }


}

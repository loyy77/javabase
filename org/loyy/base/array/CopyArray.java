package org.loyy.base.array;

/**
 * @author LiShixi
 */
public class CopyArray {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] arr1 = new int[10000];
        int[] arr2 = new int[5000];
        for (int i = 0; i < 10000; i++) {
            arr1[i] = i;

            StringBuilder sb = new StringBuilder(30000);
            System.out.print(sb.append(arr1[i]).append(","));
        }

        System.arraycopy(arr1, 0, arr2, 0, 5000);
        System.out.println();
        for (int i = 0; i < 5000; i++) {

            StringBuilder sb = new StringBuilder(20000);
            System.out.print(sb.append(arr2[i]).append(","));
        }

    }

}

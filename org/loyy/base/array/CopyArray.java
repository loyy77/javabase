package org.loyy.base.array;

/**
 * 使用 System.arraycopy(src, srcPos, dest, destPos, length);复制数组，据说比循环快！！ 参数： src
 * - 源数组。 srcPos - 源数组中的起始位置。 dest - 目标数组。 destPos - 目标数据中的起始位置。 length -
 * 要复制的数组元素的数量。
 *
 * @author LiShixi
 */
class CopyArray {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] arr1 = new int[10000];
        int[] arr2 = new int[5000];
        for (int i = 0; i < 10000; i++) {
            arr1[i] = i;
            // 使用StringBuilder拼接字符串提高性能
            StringBuilder sb = new StringBuilder(30000);
            System.out.print(sb.append(arr1[i]).append(","));
        }
        // 执行复制操作
        System.arraycopy(arr1, 0, arr2, 0, 5000);
        System.out.println();
        for (int i = 0; i < 5000; i++) {

            StringBuilder sb = new StringBuilder(20000);
            System.out.print(sb.append(arr2[i]).append(","));
        }

    }

}
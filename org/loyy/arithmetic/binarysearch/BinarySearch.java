package org.loyy.arithmetic.binarysearch;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-20
 * Time: 下午11:26
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {


    public static void main(String[] args) {


        int[] arr = genericIntArray(100);
        //  arr= rejectDuplicate(arr);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int key = 23;
        int index = bSearch(arr, key);

        System.out.printf("\n%d的索引是：%d\n", key, index);


    }

    //测试NumberCount（）
    public static void testNumberCount() {
        int[] arr = genericIntArray(100);
        Map map = numberCount(arr);
        System.out.println(map);
        Set set = map.keySet();
        Iterator it = set.iterator();
        for (; it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }

    }

    /*  一个数字出现次数计数器  */
    public static Map numberCount(int[] arr) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (count.containsKey(arr[i])) {
                count.put(arr[i], count.get(arr[i]).intValue() + 1);
            } else {

                count.put(arr[i], 1);
            }
        }
        return count;
    }

    /**
     * 返回被查找的值的索引
     */
    public static int bSearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal > key) {
                high = mid - 1;
            } else if (midVal < key) {
                low = mid + 1;
            } else {

                return mid;
            }
        }


        return -(low - 1);   //not found key
    }

    //生成一个指定长度的整形的数组
    public static int[] genericIntArray(int length) {
        int[] iArr = null;

        Random random = new Random();
        Set set = new HashSet();

        for (int i = 0; i < length; i++) {
            // iArr[i] = random.nextInt(100);
            set.add(random.nextInt(100));
        }
        iArr = new int[set.size()];
        Object[] o = set.toArray();
        for (int i = 0; i < o.length; i++) {
            iArr[i] = Integer.parseInt(o[i].toString());
        }
        return iArr;


    }

    /*    剔除重复的元素*/
    public static int[] rejectDuplicate(int[] arr) {
        Iterator it = numberCount(arr).keySet().iterator();
        int[] nArr = new int[numberCount(arr).size()];
        Object[] a = numberCount(arr).keySet().toArray();

        for (int i = 0; i < a.length; i++) {
            nArr[i] = Integer.parseInt(a[i].toString());
        }

        return nArr;
    }


}

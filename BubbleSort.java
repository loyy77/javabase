package org.loyy.base.sort;

public class BubbleSort {

	/**
	 * 只排序一个int类型数组
	 * 
	 * @param 需要排序的int类型数组
	 */
	public static void Sort(int[] list) {
		int i, j = 1, temp;
		boolean done = false;
		while ((j < list.length) && (!done)) {
			done = true;
			for (i = 0; i < list.length - j; i++) {
				if (list[i] > list[i + 1]) {
					done = false;
					temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
			j++;
		}
	}

	/**
	 * 获得一个排序后的int类型数据
	 * 
	 * @param int类型的数组
	 * @return 排序后的新int类型数组
	 */
	public static int[] SortReturn(int[] list) {
		Sort(list);
		int[] result = new int[list.length];
		for (int m = 0; m < list.length; m++) {
			result[m] = list[m];
		}
		return result;
	}

	/**
	 * 打印一个排序后的int类型数组
	 * 
	 * @param list
	 */
	public static void pirntSortResult(int[] list) {
		for (int i : SortReturn(list)) {
			System.out.print(i + " ");
		}
	}

	// /**
	// * @param args
	// */
	 public static void main(String[] args) {
	 int[] iArray = new int[] { 1, 6, 2, 4, 5, 14, 32, 23, 33, 53, 15, 21 };

 pirntSortResult(iArray);

 }

}

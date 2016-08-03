package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author kehao
 *
 */
public class SelectSort {
	/**
	 * 选择排序
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		int temp = 0;
		int flag = 0;
		int i, j;
		for (i = 0; i < arr.length; i++) {
			temp = arr[i];
			flag = i;
			for (j = i + 1; j < arr.length; j++) {// 循环求出最小值
				if (arr[j] < temp) {
					temp = arr[j];//将最小值存放在temp中
					flag = j;//记录最小值下标
				}
			}
			if (flag != i) {// 如果当前循环第一个不是最小的就需要交换
				arr[flag] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {
		int[] arr = { 9, 5, 6, 3, 8, 4, 2, 0, 1, 7 };
		System.out.println(Arrays.toString(arr));
		System.out.println("----------------------------");
		selectSort(arr);
		System.out.println("----------------------------");
		System.out.println(Arrays.toString(arr));
	}
}

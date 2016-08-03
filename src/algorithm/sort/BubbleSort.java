package algorithm.sort;

import java.util.Arrays;

/**
 * @author kehao 冒泡排序
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {
		int[] arr = { 38, 65, 97, 76, 13, 27, 49 };
		System.out.println(Arrays.toString(arr));
		System.out.println("----------------------------");
		bubbleSort(arr);
		System.out.println("----------------------------");
		System.out.println(Arrays.toString(arr));
	}
}

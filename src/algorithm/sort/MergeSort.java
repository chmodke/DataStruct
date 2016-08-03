package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
	/**
	 * 归并排序，分治，整理，合并
	 * @param arr 待排序数组
	 * @param p 左半子表起始位置
	 * @param q 左半子表结束右半子表起始
	 * @param r 右半子表结束位置
	 */
	public static void merge(int arr[], int p, int q, int r) {
		System.out.println("merge IN"+Arrays.toString(arr)+ '\t' + p + '\t' + q+ '\t' + r);
		int i, j, k, n1, n2;
		n1 = q - p + 1;
		n2 = r - q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		// 分治
		for (i = 0, k = p; i < n1; i++, k++) {
			L[i] = arr[k];
		}
		for (i = 0, k = q + 1; i < n2; i++, k++) {
			R[i] = arr[k];
		}
		// 整理
		for (k = p, i = 0, j = 0; i < n1 && j < n2; k++) {
			if (L[i] < R[j]) {
				arr[k] = L[i];// 左半表排序
				i++;
			} else {
				arr[k] = R[j];// 右半表排序
				j++;
			}
		}
		// 合并左半表
		if (i < n1) {
			for (j = i; j < n1; j++, k++) {
				arr[k] = L[j];
			}
		}
		//合并右半表
		if (j < n2) {
			for (i = j; i < n2; i++, k++) {
				arr[k] = R[i];
			}
		}
		System.out.println("mergeOUT"+Arrays.toString(arr));
		System.out.println("------------------------------------------------------------");
	}

	/**
	 * @param arr 原数组
	 * @param p 排序起始位置
	 * @param r 排序结束位置
	 */
	public static void mergeSort(int arr[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
//			System.out.println("压栈a "+Arrays.toString(arr)+ '\t' + p + '\t' + q);
			mergeSort(arr, p, q);//左半表
//			System.out.println("弹栈a "+Arrays.toString(arr)+ '\t' + p + '\t' + q);
			
//			System.out.println("压栈b "+Arrays.toString(arr)+ '\t' + (q + 1) + '\t' + r);
			mergeSort(arr, q + 1, r);//右半表
//			System.out.println("弹栈b "+Arrays.toString(arr)+ '\t' + (q + 1) + '\t' + r);
			merge(arr, p, q, r);
		}
	}

	public static void main(String[] args) {
		int[] arr = {5,4,9,8,7,6,0,1,3,2};
		System.out.println(Arrays.toString(arr));
		System.out.println("----------------------------");
		System.out.println("压栈      "+Arrays.toString(arr)+ '\t' + 0 + '\t' + (arr.length - 1));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("弹栈      "+Arrays.toString(arr)+ '\t' + 0 + '\t' + (arr.length - 1));
		System.out.println("----------------------------");
		System.out.println(Arrays.toString(arr));
	}
}

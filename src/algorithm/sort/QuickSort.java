package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 
 * @author kehao
 *
 */
public class QuickSort {
	/**
	 * 快速排序方法一
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void quickSort1(int arr[], int left, int right) {
		if (left < right) {
			int k = parition1(arr, left, right);
			// System.out.println(Arrays.toString(arr));
			System.out.println("压栈a " + left + '\t' + (k - 1));
			quickSort1(arr, left, k - 1);
			System.out.println("弹栈a " + left + '\t' + (k - 1));
			System.out.println("压栈b " + (k + 1) + '\t' + right);
			quickSort1(arr, k + 1, right);
			System.out.println("弹栈b " + (k + 1) + '\t' + right);
		}
	}

	/**
	 * 快速排序分割方式一
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int parition1(int[] arr, int left, int right) {
		int key = arr[right];// 以最后一个元素为基准点
		int i = left - 1;
		int temp;
		for (int j = left; j < right; j++) {// 以基准点为标准划分序列
			if (arr[j] < key) {
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		// 将基准点放到合适的位置
		temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;
		return i + 1;
	}

	/**
	 * 第二种快速排序算法
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void quickSort2(int arr[], int left, int right) {
		int i, j, key;
		if (left < right) {
			i = left;
			j = right;
			key = arr[i];// 以最左边的元素为标准划分基准点
			do {
				while (arr[j] > key && i < j)// 从右向左找到第一个小于基准值的位置
					j--;// 找到了位置j
				if (i < j) {// 将第j个元素置于左端并重置i
					arr[i] = arr[j];
					i++;
				}
				while (arr[i] < key && i < j)// 从左往右找到第一个大于基准值的位置
					i++;// 找到了位置i
				if (i < j) {// 将第i个元素置于右端并重置j
					arr[j] = arr[i];
					j--;
				}
			} while (i != j);
			arr[i] = key;
//			System.out.println(Arrays.toString(arr));
			System.out.println("压栈a "+Arrays.toString(arr)+ '\t' + left + '\t' + (i - 1));
			quickSort2(arr, left, i - 1);
			System.out.println("弹栈a "+Arrays.toString(arr)+ '\t' + left + '\t' + (i - 1));
			System.out.println("压栈b "+Arrays.toString(arr)+ '\t' + (i + 1) + '\t' + right);
			quickSort2(arr, i + 1, right);
			System.out.println("弹栈b "+Arrays.toString(arr)+ '\t' + (i + 1) + '\t' + right);
		}
	}

	/*public static int parition2(int arr[], int low, int high) {
		int key = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= key)
				high--;
			swap(arr[low], arr[high]);
			while (low < high && arr[low] <= key)
				++low;
			swap(arr[low], arr[high]);
		}
		return low;
	}
	public static void swap(int i, int j) {
		int t;
		t = i;
		i = j;
		j = t;
	}*/

	public static void main(String args[]) {
		// int[] arr = { 5, 7, 3, 9, 2, 6, 4, 0, 1, 8, 2 };
		int[] arr = { 3, 0, 1, 8, 7, 2, 5, 4, 9, 6 };
		System.out.println(Arrays.toString(arr));
		System.out.println("----------------------------");
		System.out.println("压栈      "+Arrays.toString(arr)+ '\t' + 0 + '\t' + (arr.length - 1));
		quickSort2(arr, 0, arr.length - 1);
		System.out.println("弹栈      "+Arrays.toString(arr)+ '\t' + 0 + '\t' + (arr.length - 1));
		System.out.println("----------------------------");
		System.out.println(Arrays.toString(arr));
	}
}

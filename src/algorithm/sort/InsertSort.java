package algorithm.sort;

import java.util.Arrays;

public class InsertSort {
	public static void insertSort(int[] arr) {
		if (arr != null) {
			for (int i = 1; i < arr.length; i++) {
				int temp = arr[i], j = i;
				if (arr[j - 1] > temp) {
					while (j >= 1 && arr[j - 1] > temp) {
						arr[j] = arr[j - 1];//比temp大的数依次后移
						j--;
					}
				}
				arr[j] = temp;//插入操作，将temp放在比temp大的值前小的值后
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	public static void insertSort2(int arr[]){
		int j,temp;
		//遍历数组
		for(int i=1;i<arr.length;i++){
			temp=arr[i];
			//寻找合适位置
			for(j=i-1;j>=0;j--){
				//当待插入元素大于当前值时就是合适位置
				if(arr[j]>temp){
					arr[j+1]=arr[j];//不符合条件时元素后移
				}else{
					break;
				}
			}
			arr[j+1]=temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 38,65,97,76,13,27,49 };
		System.out.println(Arrays.toString(arr));
		System.out.println("----------------------------");
		insertSort2(arr);
		System.out.println("----------------------------");
		System.out.println(Arrays.toString(arr));
	}
}

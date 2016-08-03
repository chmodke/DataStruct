package algorithm.recursion;

import org.junit.Test;

public class CommonSum {
	/**
	 * 普通方法求解
	 * @param n
	 * @return
	 */
	public int commonMethod01(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	/**
	 * 求和公式求解
	 * @param n
	 * @return
	 */
	public int commonMethod02(int n) {
		int sum = 0;
		sum = (1 + n) * n / 2;
		return sum;
	}

	/**
	 * 递归算法求解
	 * 
	 * @param n
	 * @return
	 */
	public int commonMethod03(int n) {
		if (n == 1) {
			return n;
		} else {
			return commonMethod03(n - 1) + n;
		}
	}
	public int commonMethod06(int n){
		@SuppressWarnings("unused")
		boolean flag=(n>0)&&(n+=commonMethod06(n-1))>0;
		return n;
	}
	@Test
	public void m01() {
		System.out.println(commonMethod01(100));
	}

	@Test
	public void m02() {
		System.out.println(commonMethod02(100));
	}

	@Test
	public void m03() {
		System.out.println(commonMethod03(100));
	}

	@Test
	public void m04() {
		CommconSumException cse = new CommconSumException(100);
		System.out.println(cse.commonMethod04(1));
	}

	@Test
	public void m05() {
		int n = 100;
		CommonSumExceptionConstructor.n = n;
		CommonSumExceptionConstructor.arr = new int[n + 1];
		new CommonSumExceptionConstructor(1);
	}
	@Test
	public void m06() {
		int n = 100;
		System.out.println(commonMethod06(n));
	}
}

/**
 * @author kehao 利用异常控制递归次数 不使用循环选择和乘除法实现累加和
 */
class CommconSumException {
	int arr[];
	int n;

	public CommconSumException(int n) {
		this.n = n;
		arr = new int[n + 1];
	}

	public int commonMethod04(int i) {
		try {
			arr[i] = arr[i - 1] + i;
			int k = commonMethod04(i + 1);
			return k;
		} catch (IndexOutOfBoundsException e) {
			return arr[n];
		}
	}
}

/**
 * @author kehao 递归调用构造函数实现累加和
 */
class CommonSumExceptionConstructor {
	public static int arr[];
	public static int n;

	public CommonSumExceptionConstructor(int i) {
		try {
			arr[i] = arr[i - 1] + i;
			new CommonSumExceptionConstructor(i + 1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(arr[n]);
			return;
		}
	}
}
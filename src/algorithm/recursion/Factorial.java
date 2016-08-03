package algorithm.recursion;

import java.util.Scanner;

/**
 * 阶乘
 * @author kehao
 */
public class Factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(factorial(scan.nextInt()));
		scan.close();
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}

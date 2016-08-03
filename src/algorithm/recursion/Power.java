package algorithm.recursion;

import java.util.Scanner;

/**
 * power x^n
 * @author kehao
 *
 */
public class Power {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(power(scan.nextInt(), scan.nextInt()));
		scan.close();
	}

	public static int power(int x, int n) {
		int y;
		if (n == 0) {
			y = 1;
		} else {
			y = power(x, n / 2);
			y = y * y;
			if (n % 2 == 1) {
				y = y * x;
			}
		}
		return y;
	}
}

package datastruct.exercise;

import java.util.Scanner;

import datastruct.implement.StackSLinked;
import datastruct.interfaces.Stack;

/**
 * @author KeHao 十进制转八进制，利用堆栈
 */
public class DecToOcto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("输入十进制整数：");
		baseConversion(scan.nextInt());
		scan.close();
	}

	public static void baseConversion(int i) {
		Stack<String> s = new StackSLinked<String>();
		while (i > 0) {
			s.push(i % 8 + "");
			i = i / 8;
		}
		while (!s.isEmpty()) {
			System.out.print((String) s.pop());
		}
	}
}

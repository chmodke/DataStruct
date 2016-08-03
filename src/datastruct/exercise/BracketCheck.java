package datastruct.exercise;

import java.util.Scanner;

import datastruct.implement.StackSLinked;
import datastruct.interfaces.Stack;

/**
 * @author KeHao 括号匹配检测
 */
public class BracketCheck {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("输入括号序列：");
		System.out.println(bracketMatch(scan.nextLine()));
		scan.close();
	}

	public static boolean bracketMatch(String str) {
		Stack<Integer> s = new StackSLinked<Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				s.push(Integer.valueOf(c));
				break;
			case '}':
				if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '{') {
					break;
				} else {
					return false;
				}
			case ']':
				if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '[') {
					break;
				} else {
					return false;
				}
			case ')':
				if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '(') {
					break;
				} else {
					return false;
				}
			}
		}
		if (s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}

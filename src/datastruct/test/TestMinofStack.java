package datastruct.test;

import algorithm.linkedList.MinOfStack;

public class TestMinofStack {
	public static void main(String[] args){		
		MinOfStack stack=new MinOfStack();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(2);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.pop();//9
		stack.pop();//8
		stack.pop();//7
		stack.pop();//2
		stack.pop();//5
		stack.pop();//2
		stack.pop();//3
	}
}

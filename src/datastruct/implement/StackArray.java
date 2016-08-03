package datastruct.implement;

import datastruct.exceptions.StackEmptyException;
import datastruct.interfaces.Stack;

/**
 * @author KeHao 堆栈顺序存储实现
 */
@SuppressWarnings("unchecked")
public class StackArray<E> implements Stack<E> {

	private final int LEN = 8;
	private E[] elements;
	private int top;

	public StackArray() {
		top = -1;
		elements = (E[])new Object[LEN];
		//TODO new E[]{LEN}
	}

	/**
	 * 数组扩容方法
	 */
	private void expandSpace() {
		E[] temp = (E[])new Object[this.elements.length * 2];
		System.arraycopy(this.elements, 0, temp, 0, this.elements.length);
		this.elements = temp;
	}

	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}

	@Override
	public void push(E e) {
		if (this.getSize() >= elements.length) {
			expandSpace();
		} else {
			elements[++top] = e;
		}
	}

	@Override
	public E pop() throws StackEmptyException {
		if(this.getSize()<1){
			throw new StackEmptyException("error:stack is empty");
		}
		E o=this.elements[top];
		this.elements[top]=null;
		top--;
		return o;
	}

	@Override
	public E peek() throws StackEmptyException {
		if(this.getSize()<1){
			throw new StackEmptyException("error:stack is empty");
		}
		E o=this.elements[top];
		return o;
	}

}

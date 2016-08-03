package datastruct.implement;

import datastruct.exceptions.StackEmptyException;
import datastruct.interfaces.Stack;

/**
 * @author KeHao 链式堆栈定义
 */
public class StackSLinked<E> implements Stack<E> {

	private SLNode<E> top;
	private int size;

	public StackSLinked() {
		top = null;
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void push(E e) {
		SLNode<E> q = new SLNode<E>(e, top);
		top = q;
		size++;
	}

	@Override
	public E pop() throws StackEmptyException {
		if (this.size < 1) {
			throw new StackEmptyException("error:stack is Empty");
		}
		E obj = top.getData();
		top = top.getNext();
		size--;
		return obj;
	}

	@Override
	public E peek() throws StackEmptyException {
		if (this.size < 1) {
			throw new StackEmptyException("error:stack is Empty");
		}
		E obj = top.getData();
		return obj;
	}

}

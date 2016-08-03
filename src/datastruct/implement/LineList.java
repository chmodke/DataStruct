package datastruct.implement;

import datastruct.exceptions.OutOfBoundaryException;
import datastruct.interfaces.List;
import datastruct.interfaces.Strategy;
@SuppressWarnings("unchecked")
public class LineList<E> implements List<E> {
	private final int LEN = 8;
	private Strategy strategy;
	private int size;
	private E[] elements;
	public LineList() {
		size = 0;
		elements = (E[]) new Object [LEN];
		//TODO new E[]{LEN}
	}

	public LineList(Strategy strategy) {
		this();
		this.strategy = strategy;
	}

	/**
	 * 数组长度扩充
	 */
	private void expandSpace() {
		E[] temp = (E[])new Object[this.elements.length * 2];
		System.arraycopy(this.elements, 0, temp, 0, this.elements.length);
		this.elements = temp;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size > 0 ? false : true);
	}

	@Override
	public boolean contains(E o) {
		boolean flag = false;
		for (int i = 0; i < this.size; i++) {
			if (strategy.equal(o, elements[i])) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public int indexOf(E o) {
		int index = -1;
		for (int i = 0; i < this.size; i++) {
			if (strategy.equal(o, elements[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public boolean insert(int n, E o) throws OutOfBoundaryException {
		boolean flag = false;
		if (n < 0 || n > this.size) {
			throw new OutOfBoundaryException("输入序号非法");
		}
		if (this.size >= this.elements.length) {
			this.expandSpace();
		}
		for (int i = size; i > n; i--) {
			this.elements[i] = this.elements[i - 1];
		}
		this.elements[n] = o;
		size++;
		flag = true;
		return flag;
	}

	@Override
	public boolean insertBefore(E e, E o) {
		int temp = this.indexOf(e);
		if (temp < 0) {
			return false;
		}
		this.insert(temp, o);
		return true;
	}

	@Override
	public boolean insertAfter(E e, E o) {
		int temp = this.indexOf(e);
		if (temp < 0) {
			return false;
		}
		this.insert(temp + 1, o);
		return true;
	}

	@Override
	public E remove(int n) throws OutOfBoundaryException {
		E obj = null;
		if (n < 0 || n > this.size) {
			throw new OutOfBoundaryException("输入序号非法");
		}
		obj = this.get(n);
		for (int i = n; i < size - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.elements[size - 1] = null;
		size--;
		return obj;
	}

	@Override
	public boolean remove(E o) {
		boolean flag = false;
		int temp = this.indexOf(o);
		if (temp < 0) {
			return flag;
		}
		if (this.remove(temp) != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public E replace(int n, E o) throws OutOfBoundaryException {
		E obj=null;
		if(n<0&&n>this.size){
			throw new OutOfBoundaryException("输入序号非法");
		}
		obj=this.get(n);
		this.elements [n]=o;
		return obj;
	}

	@Override
	public E get(int n) throws OutOfBoundaryException {
		if (n < 0 || n > this.size) {
			throw new OutOfBoundaryException("输入序号非法");
		}
		E obj = null;
		obj = this.elements[n];
		return obj;
	}

}

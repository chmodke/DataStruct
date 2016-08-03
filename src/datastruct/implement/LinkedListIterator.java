package datastruct.implement;

import datastruct.exceptions.OutOfBoundaryException;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.LinkedList;
import datastruct.interfaces.Node;

public class LinkedListIterator<E> implements Iterator<E> {
	private LinkedList<E> list;// 链接表
	private Node<E> current;// 当前节点

	public LinkedListIterator(LinkedList<E> list) {
		this.list = list;
		if (list.isEmpty()) {// 若链表为空
			current = null;// 置当前元素为null
		} else {
			current = list.first();// 否则从第一个元素开始
		}
	}

	@Override
	public void first() {
		if (list.isEmpty()) {// 若链表为空
			current = null;// 置当前元素为null
		} else {
			current = list.first();// 否则从第一个元素开始
		}
	}

	@Override
	public void next() {
		if (this.isDone()) {
			throw new OutOfBoundaryException("error,not hava next element!!!");
		}
		if (current == list.last()) {
			current = null;
		} else {
			current = list.getNext(current);
		}
	}

	@Override
	public boolean isDone() {
		return (current == null);
	}

	@Override
	public E currentItem() {
		if (isDone()) {
			throw new OutOfBoundaryException("error,not hava next element!!!");
		}
		return current.getData();
	}

}

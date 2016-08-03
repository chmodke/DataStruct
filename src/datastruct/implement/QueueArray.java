package datastruct.implement;

import datastruct.exceptions.QueueEmptyException;
import datastruct.interfaces.Queue;

/**
 * @author KeHao 顺序存储队列
 */
@SuppressWarnings("unchecked")
public class QueueArray<E> implements Queue<E> {

	private static final int CAP = 7;
	private E[] elements;
	private int capactiy;// 数组的大小elements.lenght
	private int front;// 队首
	private int rear;// 对尾

	public QueueArray() {
		this(CAP);
	}

	public QueueArray(int cap) {
		this.capactiy = cap + 1;
		this.elements = (E[])new Object[capactiy];
		//TODO new E[capactiy];
		front = rear = 0;
	}

	@Override
	public int getSize() {
		return (rear - front + capactiy) % this.capactiy;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * 数组扩容方法
	 */
	private void expandSpace() {
		E[] temp = (E[])new Object[this.elements.length * 2];
		int i = front;
		int j = 0;
		while (i != rear) {
			temp[j] = this.elements[i];
			j++;
			i = (i + 1) % this.capactiy;
		}
		this.elements = temp;
		this.capactiy = this.elements.length;
		front = 0;
		rear = j;
	}

	@Override
	public void enqueue(E e) {
		if (this.getSize() == this.capactiy - 1) {
			expandSpace();
		} else {
			this.elements[rear] = e;
			rear = (rear + 1) % this.capactiy;
		}
	}

	@Override
	public E dequeue() throws QueueEmptyException {
		if (this.isEmpty()) {
			throw new QueueEmptyException("error:queue is Empty");
		}
		E o = this.elements[front];
		this.elements[front] = null;
		front = (front + 1) % this.capactiy;
		return o;
	}

	@Override
	public E peek() throws QueueEmptyException {
		if (this.isEmpty()) {
			throw new QueueEmptyException("error:queue is Empty");
		}
		return this.elements[front];
	}

}

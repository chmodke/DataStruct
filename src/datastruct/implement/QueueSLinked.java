package datastruct.implement;

import datastruct.exceptions.QueueEmptyException;
import datastruct.interfaces.Queue;

/**
 * @author KeHao 链式存储队列
 */
public class QueueSLinked<E> implements Queue<E> {
	private SLNode<E> front;
	private SLNode<E> rear;
	private int size;

	public QueueSLinked() {
		front = new SLNode<E>();
		rear = front;
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
	public void enqueue(E e) {
		SLNode<E> q = new SLNode<E>(e, null);
		rear.setNext(q);
		rear = q;
		size++;
	}

	@Override
	public E dequeue() throws QueueEmptyException {
		if (this.size < 1) {
			throw new QueueEmptyException("error:queue is empty");
		}
		SLNode<E> p = front.getNext();
		front.setNext(p.getNext());
		size--;
		if (size < 1) {// 如果队列为空
			rear = front;
		}
		return p.getData();
	}

	@Override
	public E peek() throws QueueEmptyException {
		if (this.size < 1) {
			throw new QueueEmptyException("error:queue is empty");
		}
		SLNode<E> p = front.getNext();
		return p.getData();
	}

}

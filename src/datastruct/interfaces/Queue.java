package datastruct.interfaces;

import datastruct.exceptions.QueueEmptyException;

/**
 * @author KeHao 队列接口
 */
public interface Queue<E> {
	/**
	 * 返回队列大小
	 * 
	 * @return
	 */
	public int getSize();

	/**
	 * 检查队列是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * 将元素入队
	 * 
	 * @param e
	 */
	public void enqueue(E e);

	/**
	 * 将队首元素出队
	 * 
	 * @return
	 * @throws QueueEmptyException
	 */
	public E dequeue() throws QueueEmptyException;

	/**
	 * 取出对手元素
	 * 
	 * @return
	 * @throws QueueEmptyException
	 */
	public E peek() throws QueueEmptyException;
}

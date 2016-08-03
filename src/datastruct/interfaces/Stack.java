package datastruct.interfaces;

import datastruct.exceptions.StackEmptyException;

/**
 * @author KeHao 堆栈接口
 */
public interface Stack<E> {
	/**
	 * 返回堆栈大小
	 * @return
	 */
	public int getSize();

	/**
	 * 检查堆栈是否为空
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * 将元素压入栈顶
	 * @param o
	 */
	public void push(E e);

	/**
	 * 弹出栈顶元素
	 * @return
	 * @throws StackEmptyException
	 */
	public E pop() throws StackEmptyException;

	/**
	 * 取出栈顶元素，不弹出
	 * @return
	 * @throws StackEmptyException
	 */
	public E peek() throws StackEmptyException;
}

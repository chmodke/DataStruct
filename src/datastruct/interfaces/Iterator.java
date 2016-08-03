package datastruct.interfaces;

import datastruct.exceptions.OutOfBoundaryException;

public interface Iterator<E> {
	/**
	 * 移动到第一个元素
	 */
	public void first();

	/**
	 * 移动到下一个元素
	 */
	public void next() throws OutOfBoundaryException;

	/**
	 * 检查是否还有剩余的元素
	 * 
	 * @return true 无剩余
	 */
	public boolean isDone();

	/**
	 * 返回当前元素
	 * 
	 * @return
	 */
	public E currentItem() throws OutOfBoundaryException;
}

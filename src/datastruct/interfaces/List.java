package datastruct.interfaces;

import datastruct.exceptions.OutOfBoundaryException;

/**
 * 通用链表接口
 * @author KeHao
 *
 */
public interface List<E> {
	/**
	 * 获取链表长度
	 * @return 链表长度
	 */
	public int getSize();
	/**
	 * 判断链表是否为空
	 * @return 空返回true 非空返回false
	 */
	public boolean isEmpty();
	/**
	 * 判断链表中是否包含元素e
	 * @param e 传入元素
	 * @return true 包含 false 不包含
	 */
	public boolean contains(E e);
	/**
	 * 获取传入元素的序号
	 * @param e 传入元素
	 * @return 元素的序号
	 */
	public int indexOf(E e);
	/**
	 * 将元素e插入到第n的位置
	 * @param n 位置
	 * @param e 元素
	 * @return true 成功 false 失败
	 */
	public boolean insert(int n,E e) throws OutOfBoundaryException;
	/**
	 * 插入到指定元素之后
	 * @param o 指定元素
	 * @param e 插入元素
	 * @return true 成功 false 失败
	 */
	public boolean insertBefore(E o,E e);
	/**
	 * 插入到指定元素之前
	 * @param o 指定元素
	 * @param e 插入元素
	 * @return true 成功 false 失败
	 */
	public boolean insertAfter(E o,E e);
	/**
	 * 根据序号移除元素，并返回
	 * @param n 移除元素下标
	 * @return 被移除的元素
	 */
	public Object remove(int n) throws OutOfBoundaryException;
	/**
	 * 根据元素移除
	 * @param e 待移除的元素
	 * @return true 移除成功 false 移除失败
	 */
	public boolean remove(E e);
	/**
	 * 替换元素
	 * @param n 替换元素的下标
	 * @param e 用来替换的元素
	 * @return 被替换掉的元素
	 */
	public Object replace(int n,E e) throws OutOfBoundaryException;
	/**
	 * 获取指定序号的元素
	 * @param i 要获取的序号
	 * @return 取到的元素
	 */
	public Object get(int n) throws OutOfBoundaryException;
}

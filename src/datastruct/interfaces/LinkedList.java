package datastruct.interfaces;


import datastruct.exceptions.InvalidNodeException;
import datastruct.exceptions.OutOfBoundaryException;

/**
 * @author KeHao
 * 链接表接口
 */
public interface LinkedList<E> {
	/**
	 * 查询当前链表大小
	 * @return 链表大小
	 */
	public int getSize();
	/**
	 * 判断链表是否为空
	 * @return 空返回true
	 */
	public boolean isEmpty();
	/**
	 * 返回第一个节点
	 * @return 首节点
	 * @throws OutOfBoundaryException
	 */
	public Node<E> first() throws OutOfBoundaryException;
	/**
	 * 返回最后一个节点
	 * @return 尾节点
	 * @throws OutOfBoundaryException
	 */
	public Node<E> last() throws OutOfBoundaryException;
	/**
	 * 返回p节点的下一个节点
	 * @param p 查找的节点
	 * @return p节点的下一个节点
	 * @throws InvalidNodeException
	 * @throws OutOfBoundaryException
	 */
	public Node<E> getNext(Node<E> p) throws InvalidNodeException,OutOfBoundaryException;
	/**
	 * 返回p节点的前一个节点
	 * @param p 查找的节点
	 * @return p节点的上一个节点
	 * @throws InvalidNodeException
	 * @throws OutOfBoundaryException
	 */
	public Node<E> getPre(Node<E> p) throws InvalidNodeException,OutOfBoundaryException;
	/**
	 * 将e元素插入到首节点前
	 * @param e 待插入元素
	 * @return 插入的节点
	 */
	public Node<E> insertFirst(E e);
	/**
	 * 将e元素插入到末尾节点之后
	 * @param e 待插入元素
	 * @return 插入的节点
	 */
	public Node<E> insertLast(E e);
	/**
	 * e元素插入到p节点之前
	 * @param p 节点
	 * @param e 待插入元素
	 * @return 插入的节点
	 * @throws InvalidNodeException
	 */
	public Node<E> insertBefore(Node<E> p,E e) throws InvalidNodeException;
	/**
	 * e元素插入到p节点之后
	 * @param p 节点
	 * @param e 待插入元素
	 * @return 插入的节点
	 * @throws InvalidNodeException
	 */
	public Node<E> insertAfter(Node<E> p,E e) throws InvalidNodeException;
	/**
	 * 移除p节点
	 * @param p
	 * @return 被移除的元素
	 * @throws InvalidNodeException
	 */
	public E remove(Node<E> p) throws InvalidNodeException;
	/**
	 * 移除首节点
	 * @return 被移除的元素
	 * @throws OutOfBoundaryException
	 */
	public E removeFirst()throws OutOfBoundaryException;
	/**
	 * 移除末尾节点
	 * @return 被移除的元素
	 * @throws OutOfBoundaryException
	 */
	public E removeLast()throws OutOfBoundaryException;
	/**
	 * 使用e元素替换p节点
	 * @param p 待替换的节点
	 * @param e 元素
	 * @return 被替换的元素
	 * @throws InvalidNodeException
	 */
	public E replace(Node<E> p,E e) throws InvalidNodeException;
	/**
	 * 迭代器
	 * @return
	 */
	public Iterator<E> elements();
}

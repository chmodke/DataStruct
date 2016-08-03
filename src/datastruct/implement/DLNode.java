package datastruct.implement;

import java.io.Serializable;

import datastruct.interfaces.Node;

/**
 * @author kehao
 * 双向链表节点定义
 */
public class DLNode<E> implements Serializable, Node<E> {
	private static final long serialVersionUID = -6933359745017925008L;
	
	private E element;
	private DLNode<E> pre;
	private DLNode<E> next;
	public DLNode() {
		this(null,null,null);
	}
	/**
	 * @param element 元素
	 * @param pre 前驱
	 * @param next 后继
	 */
	public DLNode(E element, DLNode<E> pre, DLNode<E> next) {
		this.element = element;
		this.pre = pre;
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public DLNode<E> getPre() {
		return pre;
	}

	public void setPre(DLNode<E> pre) {
		this.pre = pre;
	}

	public DLNode<E> getNext() {
		return next;
	}

	public void setNext(DLNode<E> next) {
		this.next = next;
	}

	@Override
	public E getData() {
		return this.element;
	}

	@Override
	public void setData(E o) {
		this.element=o;
	}
}

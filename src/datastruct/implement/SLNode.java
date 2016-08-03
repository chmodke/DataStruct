package datastruct.implement;

import java.io.Serializable;

import datastruct.interfaces.Node;

/**
 * @author kehao
 * 单链表节点定义
 */
public class SLNode<E> implements Node<E>,Serializable{

	private static final long serialVersionUID = 2915108518900782368L;
	
	private E element;
	private SLNode<E> next;
	public SLNode() {
		this(null,null);
	}
	public SLNode(E ele,SLNode<E> next){
		this.element=ele;
		this.next=next;
	}
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public SLNode<E> getNext() {
		return next;
	}
	public void setNext(SLNode<E> next) {
		this.next = next;
	}
	@Override
	public E getData() {
		return element;
	}
	@Override
	public void setData(E o) {
		this.element=o;
	}
}

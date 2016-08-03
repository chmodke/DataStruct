package datastruct.implement;

import java.io.Serializable;

import datastruct.exceptions.OutOfBoundaryException;
import datastruct.interfaces.List;
import datastruct.interfaces.Strategy;

/**
 * @author kehao
 * 单链表的实现类
 */
public class LinkedListSLNode<E> implements List<E>, Serializable {
	private static final long serialVersionUID = 8286598002798876825L;
	private Strategy strategy;
	private SLNode<E> head;
	private int size;
	public LinkedListSLNode(Strategy strategy){
		this.strategy=strategy;
		head=new SLNode<E>();
		size=0;
	}
	//获取e元素的前驱节点
	private  SLNode<E> getPreNode(E e){
		SLNode<E> p=head;
		while(p.getNext()!=null){
			if(strategy.equal(p.getNext().getData(), e)){
				return p;
			}else{
				p=p.getNext();
			}
		}
		return null;
	}
	//获取序号为i的节点的前驱节点
	private SLNode<E> getPreNode(int i){
		SLNode<E> p=head;
		for(;i>0;i--){
			p=p.getNext();
		}
		return p;
	}
	//获取第i个节点
	private SLNode<E> getNode(int i){
		SLNode<E> p=head.getNext();
		for(;i>0;i--){
			p=p.getNext();
		}
		return p;
	}
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size<1;
	}

	@Override
	public boolean contains(E o) {
		SLNode<E> p=head.getNext();
		while(p!=null){
			if(strategy.equal(p.getData(), o)){
				return true;
			}else{
				p=p.getNext();
			}
		}
		return false;
	}

	@Override
	public int indexOf(E o) {
		SLNode<E> p=head.getNext();
		int index=0;
		while(p!=null){
			if(strategy.equal(p.getData(), o)){
				return index;
			}else{
				index++;
				p=p.getNext();
			}
		}
		return -1;
	}

	@Override
	public boolean insert(int n, E o) throws OutOfBoundaryException {
		if(n<0||n>size){
			throw new OutOfBoundaryException("指定插入位置不合法");
		}
		SLNode<E> p=getPreNode(n);
		SLNode<E> q=new SLNode<E>(o, p.getNext());
		p.setNext(q);
		size++;
		return true;
	}

	@Override
	public boolean insertBefore(E o, E e) {
		SLNode<E> p=getPreNode(o);
		if(p!=null){
			SLNode<E> q=new SLNode<E>(e, p.getNext());
			p.setNext(q);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAfter(E o, E e) {
		SLNode<E> p=getPreNode(o).getNext();
		if(p!=null){
			SLNode<E> q=new SLNode<E>(e, p.getNext());
			p.setNext(q);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public E remove(int n) throws OutOfBoundaryException {
		if(n<0||n>size){
			throw new OutOfBoundaryException("指定删除位置不合法");
		}
		SLNode<E> p=getPreNode(n);
		E o=p.getNext().getData();
		p.setNext(p.getNext().getNext());
		size--;
		return o;
	}

	@Override
	public boolean remove(E o) {
		SLNode<E> p=getPreNode(o);
		if(p!=null){
			p.setNext(p.getNext().getNext());
			size--;
			return true;
		}
		return false;
	}

	@Override
	public E replace(int n, E o) throws OutOfBoundaryException {
		if(n<0||n>size){
			throw new OutOfBoundaryException("指定替换位置不合法");
		}
		SLNode<E> p=getNode(n);
		E t=p.getData();
		p.setData(o);
		return t;
	}

	@Override
	public E get(int n) throws OutOfBoundaryException {
		if(n<0||n>size){
			throw new OutOfBoundaryException("指定获取位置不合法");
		}
		SLNode<E> p=getNode(n);
		return p.getData();
	}
}

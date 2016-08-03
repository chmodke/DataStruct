package datastruct.implement;



import datastruct.exceptions.InvalidNodeException;
import datastruct.exceptions.OutOfBoundaryException;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.LinkedList;
import datastruct.interfaces.Node;

public class LinkedListDLNode<E> implements LinkedList<E> {
	private int size;
	private DLNode<E> head;
	private DLNode<E> tail;
	public LinkedListDLNode() {
		size=0;
		head=new DLNode<E>();
		tail=new DLNode<E>();
		head.setNext(tail);
		tail.setPre(head);
	}
	
	/** 判断节点是否合法
	 * @param p
	 * @return
	 * @throws InvalidNodeException
	 */
	protected DLNode<E> CheckPosition(Node<E> p) throws InvalidNodeException{
		if(p==null){
			throw new InvalidNodeException("error p is null!!!");
		}
		if(p==head){
			throw new InvalidNodeException("error p is head!!!");
		}
		if(p==tail){
			throw new InvalidNodeException("error p is tail!!!");
		}
		return (DLNode<E>)p;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Node<E> first() throws OutOfBoundaryException {
		if(isEmpty()){
			throw new InvalidNodeException("error LinkedList is NULL!!!");
		}
		return head.getNext();
	}

	@Override
	public Node<E> last() throws OutOfBoundaryException {
		if(isEmpty()){
			throw new InvalidNodeException("error LinkedList is NULL!!!");
		}
		return tail.getPre();
	}

	@Override
	public Node<E> getNext(Node<E> p) throws InvalidNodeException,
			OutOfBoundaryException {
		DLNode<E> node=this.CheckPosition(p).getNext();
		if(node==tail){
			throw new InvalidNodeException("error at last");
		}
		return node;
	}

	@Override
	public Node<E> getPre(Node<E> p) throws InvalidNodeException,
			OutOfBoundaryException {
		DLNode<E> node=this.CheckPosition(p).getPre();
		if(node==head){
			throw new InvalidNodeException("error at head");
		}
		return node;
	}

	@Override
	public Node<E> insertFirst(E e) {
		DLNode<E> node=new DLNode<E>(e,head,head.getNext());
		head.getNext().setPre(node);
		head.setNext(node);
		size++;
		return node;
	}

	@Override
	public Node<E> insertLast(E e) {
		DLNode<E> node=new DLNode<E>(e,tail.getPre(),tail);
		tail.getPre().setNext(node);
		tail.setPre(node);
		size++;
		return node;
	}

	@Override
	public Node<E> insertBefore(Node<E> p, E e) throws InvalidNodeException {
		DLNode<E> node=this.CheckPosition(p);
		DLNode<E> newNode=new DLNode<E>(e,node.getPre(),node);
		node.getPre().setNext(newNode);
		node.setPre(newNode);
		size++;
		return newNode;
	}

	@Override
	public Node<E> insertAfter(Node<E> p, E e) throws InvalidNodeException {
		DLNode<E> node =this.CheckPosition(p);
		DLNode<E> newNode=new DLNode<E>(e,node,node.getNext());
		node.getNext().setPre(newNode);
		node.setNext(newNode);
		size++;
		return newNode;
	}

	@Override
	public E remove(Node<E> p) throws InvalidNodeException {
		DLNode<E> node=this.CheckPosition(p);
		node.getPre().setNext(node.getNext());
		node.getNext().setPre(node.getPre());
		size--;
		return node.getData();
	}

	@Override
	public E removeFirst() throws OutOfBoundaryException {
		DLNode<E> node=head.getNext();
		head.getNext().getNext().setPre(head);
		head.setNext(node.getNext());
		return node.getData();
	}

	@Override
	public E removeLast() throws OutOfBoundaryException {
		DLNode<E> node=tail.getPre();
		tail.getPre().getPre().setNext(tail);
		tail.setPre(node.getPre());
		return node.getData();
	}

	@Override
	public E replace(Node<E> p, E e) throws InvalidNodeException {
		DLNode<E> node=this.CheckPosition(p);
		E o=node.getData();
		node.setData(e);
		return o;
	}

	@Override
	public Iterator<E> elements() {
		return new LinkedListIterator<E>(this);
	}
}

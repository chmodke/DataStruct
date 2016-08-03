package datastruct.implement;

import datastruct.interfaces.BinTree;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.LinkedList;
import datastruct.interfaces.Queue;
import datastruct.interfaces.Stack;
import datastruct.interfaces.Strategy;

/**
 * @author kehao
 *
 * @param <E>
 */
public class BinTreeLinked<E> implements BinTree<E> {
	private BinTreeNode<E> root;
	private Strategy strategy;

	public BinTreeLinked() {
		this(null, null);
	}

	public BinTreeLinked(BinTreeNode<E> e, Strategy strategy) {
		root = e;
		this.strategy = strategy;
	}

	@Override
	public int getSize() {
		return root.getSize();
	}

	@Override
	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	@Override
	public BinTreeNode<E> getRoot() {
		return root;
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public BinTreeNode<E> find(E e) {
		return searchE(root, e);
	}

	/**
	 * 递归查找元素e
	 * 
	 * @param rt
	 * @param e
	 * @return
	 */
	private BinTreeNode<E> searchE(BinTreeNode<E> rt, E e) {
		if (rt == null) {
			return null;
		}
		// 如果是根节点返回根
		if (strategy.equal(rt.getData(), e)) {
			return rt;
		}
		// 查找左子树
		BinTreeNode<E> var = searchE(rt.getLChild(), e);
		// 左子树中没找到，查找右子树
		if (var == null) {
			var = searchE(rt.getRChild(), e);
		}
		return var;
	}

	@Override
	public Iterator<BinTreeNode<E>> preOrder() {
		LinkedList<BinTreeNode<E>> list = new LinkedListDLNode<BinTreeNode<E>>();
		preOrderRecursion(this.root, list);
		// preOrderTraverse(this.root, list);
		return list.elements();
	}

	/**
	 * 先序遍历的递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	private void preOrderRecursion(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		// 递归退出条件
		if (rt == null) {
			return;
		}
		// 访问根节点
		list.insertLast(rt);
		// 遍历左子树
		preOrderRecursion(rt.getLChild(), list);
		// 遍历右子树
		preOrderRecursion(rt.getRChild(), list);
	}

	/**
	 * 先序遍历的非递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	@SuppressWarnings("unused")
	private void preOrderTraverse(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		if (rt == null) {
			return;
		}
		BinTreeNode<E> p = rt;
		Stack<BinTreeNode<E>> s = new StackSLinked<BinTreeNode<E>>();
		while (p != null) {
			while (p != null) {
				list.insertLast(p);// 根节点入栈
				if (p.hasRChild()) {// 右子树节点入栈
					s.push(p.getRChild());
				}
				p = p.getLChild();
			}
			if (!s.isEmpty()) {// 右子树根节点出栈遍历右子树
				p = s.pop();
			}
		}
	}

	@Override
	public Iterator<BinTreeNode<E>> inOrder() {
		LinkedList<BinTreeNode<E>> list = new LinkedListDLNode<BinTreeNode<E>>();
		inOrderRecursion(this.root, list);
		return list.elements();
	}

	/**
	 * 中序遍历递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	private void inOrderRecursion(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		// 递归退出条件
		if (rt == null) {
			return;
		}
		// 遍历左子树
		preOrderRecursion(rt.getLChild(), list);
		// 访问根节点
		list.insertLast(rt);
		// 遍历右子树
		preOrderRecursion(rt.getRChild(), list);
	}

	/**
	 * 中序遍历非递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	@SuppressWarnings("unused")
	private void inOrderTraverse(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		if (rt == null) {
			return;
		}
		BinTreeNode<E> p = rt;
		Stack<BinTreeNode<E>> s = new StackSLinked<BinTreeNode<E>>();
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p);// 将根节点入栈
				p = p.getLChild();// 一直向左走
			}
			if (!s.isEmpty()) {
				p = s.pop();// 取出栈顶根节点访问
				list.insertLast(p);
				p = p.getRChild();// 转向根的右子树进行遍历
			}
		}
	}

	@Override
	public Iterator<BinTreeNode<E>> postOrder() {
		LinkedList<BinTreeNode<E>> list = new LinkedListDLNode<BinTreeNode<E>>();
		postOrderRecursion(this.root, list);
		return list.elements();
	}

	/**
	 * 后序遍历递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	private void postOrderRecursion(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		// 递归退出条件
		if (rt == null) {
			return;
		}
		// 遍历左子树
		preOrderRecursion(rt.getLChild(), list);
		// 遍历右子树
		preOrderRecursion(rt.getRChild(), list);
		// 访问根节点
		list.insertLast(rt);
	}

	/**
	 * 后序遍历非递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	@SuppressWarnings("unused")
	private void postOrderTraverse(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		if (rt == null) {
			return;
		}
		BinTreeNode<E> p = rt;
		Stack<BinTreeNode<E>> s = new StackSLinked<BinTreeNode<E>>();
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p);// 根节点入栈
				if (p.hasLChild()) {// 先左后右入栈
					p = p.getLChild();
				} else {
					p = p.getRChild();
				}
			}
			if (!s.isEmpty()) {
				p = s.pop();// 取出根节点并访问
				list.insertLast(p);
			}
			// 满足条件时，说明栈顶根节点右子树已访问，应该出栈访问
			while (!s.isEmpty() && s.peek().getRChild() == p) {
				p = s.pop();
				list.insertLast(p);
			}
			// 转向栈顶根节点右子树继续后序遍历
			if (!s.isEmpty()) {
				p = s.peek().getRChild();
			} else {
				p = null;
			}
		}
	}

	@Override
	public Iterator<BinTreeNode<E>> levelOrder() {
		LinkedList<BinTreeNode<E>> list = new LinkedListDLNode<BinTreeNode<E>>();
		// levelOrderRecursion(this.root,list);
		levelOrderTraverse(this.root, list);
		return list.elements();
	}

	/**
	 * 层序遍历递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	@SuppressWarnings("unused")
	private void levelOrderRecursion(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		// TODO 3
	}

	/**
	 * 层序遍历非递归算法
	 * 
	 * @param rt
	 * @param list
	 */
	private void levelOrderTraverse(BinTreeNode<E> rt, LinkedList<BinTreeNode<E>> list) {
		if (rt == null) {
			return;
		}
		Queue<BinTreeNode<E>> q = new QueueArray<BinTreeNode<E>>();
		q.enqueue(rt);// 根节点入队
		while (!q.isEmpty()) {
			BinTreeNode<E> p = q.dequeue();// 取出队首节点并访问
			list.insertLast(p);
			if (p.hasLChild()) {// 将p的非空左孩子入队
				q.enqueue(p.getLChild());
			}
			if (p.hasRChild()) {// 将p的非空右孩子入队
				q.enqueue(p.getRChild());
			}
		}
	}

}

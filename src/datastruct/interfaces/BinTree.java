package datastruct.interfaces;

import datastruct.implement.BinTreeNode;

public interface BinTree<E> {
	int getSize();
	boolean isEmpty();
	/**
	 * 返回二叉树的根节点
	 * @return
	 */
	BinTreeNode<E> getRoot();
	/**
	 * 返回二叉树的高度
	 * @return
	 */
	int getHeight();
	/**
	 * 查找数据元素e所在的节点，若e不存在则返回null
	 * @param e
	 * @return
	 */
	BinTreeNode<E> find(E e);
	/**
	 * 先序
	 * @return
	 */
	Iterator<BinTreeNode<E>> preOrder();
	/**
	 * 中序
	 * @return
	 */
	Iterator<BinTreeNode<E>> inOrder();
	/**
	 * 后序
	 * @return
	 */
	Iterator<BinTreeNode<E>> postOrder();
	/**
	 * 按层遍历
	 * @return
	 */
	Iterator<BinTreeNode<E>> levelOrder();
}

package datastruct.implement;

import datastruct.interfaces.Node;

/**
 * @author kehao 二叉树存储节点定义，三叉链表
 * @param <E>
 */
public class BinTreeNode<E> implements Node<E> {
	private E data;
	private BinTreeNode<E> parent;
	private BinTreeNode<E> lChild;
	private BinTreeNode<E> rChild;
	private int height;
	private int size;

	public BinTreeNode() {
		this(null);
	}

	public BinTreeNode(E o) {
		data = o;
		height = 0;
		size = 1;
		parent = lChild = rChild;
	}

	@Override
	public E getData() {
		return data;
	}

	@Override
	public void setData(E o) {
		data = o;
	}

	// 辅助方法
	/**
	 * 判断节点是否有父亲
	 * 
	 * @return
	 */
	public boolean hasParent() {
		return parent != null;
	}

	/**
	 * 判断节点是否有左孩子
	 * 
	 * @return
	 */
	public boolean hasLChild() {
		return lChild != null;
	}

	/**
	 * 判断节点是否有右孩子
	 * 
	 * @return
	 */
	public boolean hasRChild() {
		return rChild != null;
	}

	/**
	 * 判断节点是否是叶子节点
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return !hasLChild() && !hasRChild();
	}

	/**
	 * 判断节点是否是某节点左孩子
	 * 
	 * @return
	 */
	public boolean isLChild() {
		return (hasParent() && this == parent.lChild);
	}

	/**
	 * 判断节点是否是某节点右孩子
	 * 
	 * @return
	 */
	public boolean isRChild() {
		return (hasParent() && this == parent.rChild);
	}

	/**
	 * 以该节点为根的树的高度
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 更新当前节点及其祖先的高度
	 */
	public void updateHeight() {
		// 初始化心高度等于0，高度等于左右子树高度加1中的 大者
		int newHeight = 0;
		if (hasLChild()) {
			newHeight = Math.max(newHeight, 1 + this.getLChild().getHeight());
		}
		if (hasRChild()) {
			newHeight = Math.max(newHeight, 1 + this.getRChild().getHeight());
		}
		// 高度没有发生改变则直接返回
		if (height == newHeight) {
			return;
		}
		// 更新高度
		height = newHeight;
		// 递归更新祖先的高度
		if (hasParent()) {
			this.getParent().updateHeight();
		}
	}

	/**
	 * 取以该节点为根的树的节点数
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 更新当前节点及其祖先的子孙数
	 */
	public void updateSize() {
		// 初始化为1
		size = 1;
		// 加上左子树规模
		if (this.hasLChild()) {
			size += this.getLChild().getSize();
		}
		// 加上右子树规模
		if (this.hasRChild()) {
			size += this.getRChild().getSize();
		}
		// 递归更新祖先的规模
		if (hasParent()) {
			this.getParent().updateSize();
		}
	}

	public BinTreeNode<E> getParent() {
		return parent;
	}

	/**
	 * 断开与父节点的关系
	 */
	public void sever() {
		if (!hasParent()) {
			return;
		}
		if (isLChild()) {
			parent.lChild = null;
		} else {
			parent.rChild = null;
		}
		// 更新父节点及祖先的高度
		parent.updateHeight();
		// 更新父节点及祖先的规模
		parent.updateSize();
		parent = null;
	}

	public BinTreeNode<E> getLChild() {
		return lChild;
	}

	/**
	 * 设置当前节点的左孩子并返回原左孩子
	 * 
	 * @param lc
	 * @return
	 */
	public BinTreeNode<E> setLChild(BinTreeNode<E> lc) {
		BinTreeNode<E> oldLC = this.lChild;
		// 断开当前节点左孩子与节点的关系
		if (hasLChild()) {
			lChild.sever();
		}
		if (lc != null) {
			// 断开lc与其父节点的关系
			lc.sever();
			// 确定父子关系
			this.lChild = lc;
			lc.parent = this;
			// 更新当前点及祖先的高度
			this.updateHeight();
			// 更新当前点及祖先的规模
			this.updateSize();
		}
		// 返回原左孩子
		return oldLC;
	}

	public BinTreeNode<E> getRChild() {
		return rChild;
	}

	/**
	 * 设置当前节点的右孩子并返回原右孩子
	 * 
	 * @param lc
	 * @return
	 */
	public BinTreeNode<E> setRChild(BinTreeNode<E> rc) {
		BinTreeNode<E> oldRC = this.rChild;
		// 断开当前节点右孩子与节点的关系
		if (hasRChild()) {
			rChild.sever();
		}
		if (rc != null) {
			// 断开rc与其父节点的关系
			rc.sever();
			// 确定父子关系
			this.rChild = rc;
			rc.parent = this;
			// 更新当前点及祖先的高度
			this.updateHeight();
			// 更新当前点及祖先的规模
			this.updateSize();
		}
		// 返回原右孩子
		return oldRC;
	}
}

package datastruct.test;

import java.util.Random;

import datastruct.implement.BinTreeLinked;
import datastruct.implement.BinTreeNode;
import datastruct.implement.HuffmanTreeNode;
import datastruct.implement.LineList;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.List;
import datastruct.myUtil.Log;

public class HuffmanTreeTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		HuffmanTreeNode<String>[] nodes = new HuffmanTreeNode[6];
		nodes[0] = new HuffmanTreeNode<String>(7, 0 + "");
		nodes[1] = new HuffmanTreeNode<String>(4, 1 + "");
		nodes[2] = new HuffmanTreeNode<String>(2, 2 + "");
		nodes[3] = new HuffmanTreeNode<String>(9, 3 + "");
		nodes[4] = new HuffmanTreeNode<String>(15, 4 + "");
		nodes[5] = new HuffmanTreeNode<String>(5, 5 + "");
		HuffmanTreeNode<String> root = buildHuffmanTree(nodes);
		BinTreeLinked<String> tree = new BinTreeLinked(root, null);
		generateHuffmanCode(root);
		printList(tree);
	}

	/**
	 * 通过节点数组生成Huffman树
	 * 
	 * @param nodes
	 * @return Huffman树根节点
	 */
	private static HuffmanTreeNode<String> buildHuffmanTree(HuffmanTreeNode<String>[] nodes) {
		int n = nodes.length;
		if (n < 2) {
			return nodes[0];
		}
		List<HuffmanTreeNode<String>> l = new LineList<HuffmanTreeNode<String>>();
		// 将节点按权值从大到小插入线性表
		for (int i = 0; i < n; i++) {
			insertToList(l, nodes[i]);
		}
		// 选择权值最小的两棵树合并，循环n-1次
		for (int i = 1; i < n; i++) {
			HuffmanTreeNode<String> min1 = l.remove(l.getSize() - 1);
			HuffmanTreeNode<String> min2 = l.remove(l.getSize() - 1);
			HuffmanTreeNode<String> newRoot = new HuffmanTreeNode<String>(min1.getWeight() + min2.getWeight());
			newRoot.setLChild(min1);
			newRoot.setRChild(min2);
			insertToList(l, newRoot);// 新树插入线性表
		}
		return l.get(0);// 返回Huffman树的根
	}

	/**
	 * 按照权值从大到小的顺序插入线性表
	 * 
	 * @param l
	 * @param node
	 */
	private static void insertToList(List<HuffmanTreeNode<String>> l, HuffmanTreeNode<String> node) {
		for (int j = 0; j < l.getSize(); j++) {
			if (node.getWeight() > l.get(j).getWeight()) {
				l.insert(j, node);
				return;
			}
		}
		l.insert(l.getSize(), node);
	}

	/**
	 * 递归生成Huffman编码
	 * 
	 * @param root
	 */
	private static void generateHuffmanCode(HuffmanTreeNode<String> root) {
		if (root == null) {
			return;
		}
		if (root.hasParent()) {
			if (root.isLChild()) {
				root.setCoding(root.getParent().getCoding() + "0");
			} else {
				root.setCoding(root.getParent().getCoding() + "1");
			}
		}
		generateHuffmanCode(root.getLChild());
		generateHuffmanCode(root.getRChild());
	}

	private static void printList(BinTreeLinked<String> stus) {
		Iterator<BinTreeNode<String>> it = stus.preOrder();
		while (!it.isDone()) {
			HuffmanTreeNode<String> s = (HuffmanTreeNode<String>) it.currentItem();
			if (s.getData() != null) {
				Log.logOut("printList:" + s.getCoding() + '\t' + s.getData() + '\t' + s.getWeight());
				System.out.println(s.getCoding() + '\t' + s.getData() + '\t' + s.getWeight());
			}
			it.next();
		}
	}
}
package datastruct.implement;

import datastruct.exceptions.UnsupportOperation;
import datastruct.interfaces.Graph;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.LinkedList;
import datastruct.interfaces.Node;
import datastruct.interfaces.Queue;
import datastruct.interfaces.Stack;

/**
 * @author kehao 图共有抽象类
 */
public abstract class AbstractGraph implements Graph {

	/**
	 * 图的顶点表
	 */
	protected LinkedList<Vertex> vertexs;
	/**
	 * 图的边表
	 */
	protected LinkedList<Edge> edges;
	/**
	 * 图的类型
	 */
	protected int type;

	public AbstractGraph(int type) {
		this.type = type;
		vertexs = new LinkedListDLNode<Vertex>();
		edges = new LinkedListDLNode<Edge>();
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public int getVexNum() {
		return vertexs.getSize();
	}

	@Override
	public int getEdgeNum() {
		return edges.getSize();
	}

	@Override
	public Iterator<Vertex> getVertex() {
		return vertexs.elements();
	}

	@Override
	public Iterator<Edge> getEdge() {
		return edges.elements();
	}

	@Override
	public Node<Vertex> insert(Vertex v) {
		return vertexs.insertLast(v);
	}

	@Override
	public Node<Edge> insert(Edge e) {
		return edges.insertLast(e);
	}

	@Override
	public boolean areAdjacent(Vertex u, Vertex v) {
		return edgeFromTo(u, v) == null;
	}

	@Override
	public Iterator<Vertex> DFSTraverse(Vertex v) {
		LinkedList<Vertex> traverseSeq = new LinkedListDLNode<Vertex>();// 遍历结果
		resetVexStatus();
		DFSRecursion(v, traverseSeq);
		Iterator<Vertex> it = getVertex();
		for (it.first(); !it.isDone(); it.next()) {
			Vertex u = it.currentItem();
			if (!u.isVisited()) {
				DFSRecursion(u, traverseSeq);
			}
		}
		return traverseSeq.elements();
	}

	/**
	 * 从顶点v出发的深度优先遍历递归算法
	 * 
	 * @param v
	 * @param list
	 */
	private void DFSRecursion(Vertex v, LinkedList<Vertex> list) {
		v.setToVisited();
		list.insertLast(v);
		Iterator<Vertex> it = adjVertexs(v);
		for (it.first(); !it.isDone(); it.next()) {
			Vertex u = it.currentItem();
			if (!u.isVisited()) {
				DFSRecursion(u, list);
			}
		}
	}

	/**
	 * 从顶点v出发的深度优先遍历非递归算法
	 * 
	 * @param v
	 * @param list
	 */
	@SuppressWarnings("unused")
	private void DFS(Vertex v, LinkedList<Vertex> list) {
		Stack<Vertex> s = new StackSLinked<Vertex>();
		s.push(v);// 初始顶点v入栈
		while (!s.isEmpty()) {
			Vertex u = s.pop();
			if (!u.isVisited()) {
				u.setToVisited();
				list.insertLast(u);
				Iterator<Vertex> it = adjVertexs(u);
				// 遍历违背访问过的邻接点
				for (it.first(); !it.isDone(); it.next()) {
					Vertex adj = it.currentItem();
					if (!adj.isVisited()) {
						s.push(adj);
					}
				}
			}
		}
	}

	/**
	 * 重置所有顶点状态
	 */
	protected void resetVexStatus() {
		Iterator<Vertex> it = getVertex();
		for (it.first(); !it.isDone(); it.next()) {
			Vertex v = it.currentItem();
			v.resetStatus();
		}
	}

	@Override
	public Iterator<Vertex> BFSTraverse(Vertex v) {
		LinkedList<Vertex> traverseSeq = new LinkedListDLNode<Vertex>();
		resetVexStatus();// 重置节点状态
		BFS(v, traverseSeq);// 从顶点v开始广度优先搜索
		Iterator<Vertex> it = getVertex();
		// 从图中未被访问的顶点重新搜索
		for (it.first(); !it.isDone(); it.next()) {
			Vertex u = it.currentItem();
			if (!u.isVisited()) {
				BFS(u, traverseSeq);
			}
		}
		return traverseSeq.elements();
	}

	/**
	 * 广度优先搜索算法
	 * 
	 * @param v
	 * @param list
	 */
	private void BFS(Vertex v, LinkedList<Vertex> list) {
		Queue<Vertex> q = new QueueSLinked<Vertex>();
		v.setToVisited();// 访问顶点v
		list.insertLast(v);
		q.enqueue(v);// 顶点v入队
		while (!q.isEmpty()) {
			Vertex u = q.dequeue();// 队首元素出队
			Iterator<Vertex> it = adjVertexs(u);
			// 访问其未被访问的邻接点
			for (it.first(); !it.isDone(); it.next()) {
				Vertex adj = it.currentItem();
				if (!adj.isVisited()) {
					adj.setToVisited();
					list.insertLast(adj);
					q.enqueue(adj);
				}
			}
		}
	}

	@Override
	public Iterator<Edge> shortestPath(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 重置图中各边的状态信息
	 */
	protected void resetEdgeType() {
		Iterator<Edge> it = getEdge();
		for (it.first(); !it.isDone(); it.next()) {
			Edge e = (Edge) it.currentItem();
			e.resetType();
		}
	}

	public abstract void remove(Vertex v);

	public abstract void remove(Edge e);

	public abstract Edge edgeFromTo(Vertex u, Vertex v);

	public abstract Iterator<Vertex> adjVertexs(Vertex u);

	public abstract void generateMST() throws UnsupportOperation;

	public abstract Iterator<Vertex> toplogicalSort() throws UnsupportOperation;

	public abstract void criticalPath() throws UnsupportOperation;
}

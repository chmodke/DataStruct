package datastruct.implement;

import datastruct.interfaces.Graph;
import datastruct.interfaces.LinkedList;
import datastruct.interfaces.Node;

/**
 * @author kehao 图的双链式存储结构定点定义
 */
public class Vertex {
	/**
	 * 顶点信息
	 */
	private Object info;
	/**
	 * 一个顶点可以有多个出度和入度，且数量不确定，故采用链式存储 //出度链表
	 */
	private LinkedList<Edge> adjacentEdges;
	/**
	 * 一个顶点可以有多个出度和入度，且数量不确定，故采用链式存储 //入度链表
	 */
	private LinkedList<Edge> reAdjacentEdges;
	/**
	 * 顶点是否被访问
	 */
	private boolean visited;
	/**
	 * 顶点在顶点链表中个的位置
	 */
	private Node<Vertex> vexPosition;// 顶点在顶点表中的位置
	/**
	 * 当前图的类型
	 */
	private int graphType;
	/**
	 * 顶点应用信息
	 */
	private Object application;

	public Vertex(Graph g, Object info) {
		this.info = info;
		adjacentEdges = new LinkedListDLNode<Edge>();
		reAdjacentEdges = new LinkedListDLNode<Edge>();
		visited = false;
		graphType = g.getType();
		vexPosition = g.insert(this);
		application = null;
	}

	private boolean isUnDiGraphNode() {
		return graphType == Graph.UndirectedGraph;
	}

	/**
	 * 获取顶点信息
	 * 
	 * @return
	 */
	public Object getInfo() {
		return info;
	}

	/**
	 * 设置顶点信息
	 * 
	 * @param info
	 */
	public void setInfo(Object info) {
		this.info = info;
	}

	/**
	 * 获取图的图
	 * 
	 * @return
	 */
	public int getDeg() {
		if (isUnDiGraphNode()) {
			return adjacentEdges.getSize();
		} else {
			// 有向图的度为出度加入度
			return getOutDeg() + getInDeg();
		}
	}

	/**
	 * 获取入度
	 * 
	 * @return
	 */
	public int getInDeg() {
		return adjacentEdges.getSize();
	}

	/**
	 * 获取出度
	 * 
	 * @return
	 */
	public int getOutDeg() {
		if (isUnDiGraphNode()) {
			// 无向图的入度为就是它的度
			return adjacentEdges.getSize();
		} else {
			// 有向图的入度为逆邻接表的规模
			return reAdjacentEdges.getSize();
		}
	}

	/**
	 * 返回所有邻接边
	 * 
	 * @return
	 */
	public LinkedList<Edge> getAdjacentEdges() {
		return adjacentEdges;
	}

	/**
	 * 返回所有逆邻接边
	 * 
	 * @return
	 */
	public LinkedList<Edge> getReAdjacentEdges() {
		if (isUnDiGraphNode()) {
			return adjacentEdges;
		} else {
			return reAdjacentEdges;
		}
	}

	/**
	 * 取顶点在所属图顶点集中的位置
	 * 
	 * @return
	 */
	public Node<Vertex> getVexPosition() {
		return vexPosition;
	}

	/**
	 * 顶点是否被访问
	 * 
	 * @return
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * 将顶点设置成访问过
	 */
	public void setToVisited() {
		visited = true;
	}

	/**
	 * 将顶点设置成未访问状态
	 */
	public void setToUnvisited() {
		visited = false;
	}

	/**
	 * 获取应用信息
	 * 
	 * @return
	 */
	protected Object getApplication() {
		return application;
	}

	/**
	 * 设置应用信息
	 * 
	 * @param application
	 */
	protected void setApplication(Object application) {
		this.application = application;
	}

	/**
	 * 重置顶点信息
	 */
	public void resetStatus() {
		visited = false;
		application = null;
	}
}

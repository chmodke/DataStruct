package datastruct.implement;

import datastruct.interfaces.Graph;
import datastruct.interfaces.Node;

/**
 * @author kehao 图的双链式存储结构边定义
 */
public class Edge {
	public static final int NORMAL = 0;
	/**
	 * MST边
	 */
	public static final int MST = 1;
	/**
	 * 关键路径中的边
	 */
	public static final int CRITICAL = 2;
	private int weight;// 权值
	private Object info;// 边的信息
	private Node<Edge> edgePosition;// 边在边标中的位置
	private Node<Vertex> firstVexPosition;// 边的第一顶点在顶点表中的位置
	private Node<Vertex> secondVexPosition;// 边的第二顶点在顶点表中的位置
	private Node<Edge> edgeFirstPosition;// 边在第一顶点的邻接(逆邻接)边表中的位置
	private Node<Edge> edgeSecondPosition;// 边在第二顶点的邻接(逆邻接)边表中的位置
	// 在无向图中就是在顶点邻接边表中的位置
	private int type;// 边的类型
	private int graphType;// 所在图的类型

	public Edge(Graph g, Vertex u, Vertex v, Object info) {
		this(g, u, v, info, 1);
	}

	public Edge(Graph g, Vertex u, Vertex v, Object info, int weight) {
		this.info = info;
		this.weight = weight;
		edgePosition = g.insert(this);
		firstVexPosition = u.getVexPosition();
		secondVexPosition = v.getVexPosition();
		type = Edge.NORMAL;
		graphType = g.getType();
		if (graphType == Graph.UndirectedGraph) {
			edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
			edgeSecondPosition = v.getAdjacentEdges().insertLast(this);
		} else {
			edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
			edgeSecondPosition = v.getReAdjacentEdges().insertLast(this);
		}
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Vertex getFirstVex() {
		return firstVexPosition.getData();
	}

	public Vertex getScondVex() {
		return secondVexPosition.getData();
	}

	public Node<Edge> getEdgePosition() {
		return edgePosition;
	}

	public Node<Vertex> getFirstVexPosition() {
		return firstVexPosition;
	}

	public Node<Vertex> getSecondVexPosition() {
		return secondVexPosition;
	}

	public Node<Edge> getEdgeFirstPosition() {
		return edgeFirstPosition;
	}

	public Node<Edge> getEdgeSecondPosition() {
		return edgeSecondPosition;
	}

	public void setToMST() {
		type = Edge.MST;
	}

	public void setToCritical() {
		type = Edge.CRITICAL;
	}

	public void resetType() {
		type = Edge.NORMAL;
	}

	public boolean isMSTEdge() {
		return type == Edge.MST;
	}

	public boolean isCritical() {
		return type == Edge.CRITICAL;
	}
}

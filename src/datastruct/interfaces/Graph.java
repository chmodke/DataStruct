package datastruct.interfaces;

import datastruct.exceptions.UnsupportOperation;
import datastruct.implement.Edge;
import datastruct.implement.Vertex;

public interface Graph {
	/**
	 * 无向图
	 */
	public static final int UndirectedGraph = 0;
	/**
	 * 有向图
	 */
	public static final int DirectedGraph = 1;

	/**
	 * 返回图的类型
	 * 
	 * @return
	 */
	public int getType();

	/**
	 * 返回图的顶点数
	 * 
	 * @return
	 */
	public int getVexNum();

	/**
	 * 返回图的边数
	 * 
	 * @return
	 */
	public int getEdgeNum();

	/**
	 * 返回图的所有顶点
	 * 
	 * @return
	 */
	public Iterator<Vertex> getVertex();

	/**
	 * 返回图的所有边
	 * 
	 * @return
	 */
	public Iterator<Edge> getEdge();

	/**
	 * 删除一个顶点
	 * 
	 * @param v
	 */
	public void remove(Vertex v);

	/**
	 * 删除一条边
	 * 
	 * @param e
	 */
	public void remove(Edge e);

	/**
	 * 插入一个顶点
	 * 
	 * @param v
	 * @return
	 */
	public Node<Vertex> insert(Vertex v);

	/**
	 * 插入一条边
	 * 
	 * @param e
	 * @return
	 */
	public Node<Edge> insert(Edge e);

	/**
	 * 判断顶点u和顶点v是否连通
	 * 
	 * @param u
	 * @param v
	 * @return
	 */
	public boolean areAdjacent(Vertex u, Vertex v);

	/**
	 * 返回从u指向v的路径，不存在返回null
	 * 
	 * @param u
	 * @param v
	 * @return
	 */
	public Edge edgeFromTo(Vertex u, Vertex v);

	/**
	 * 返回从u出发可以直接到达的邻接顶点
	 * 
	 * @param u
	 * @return
	 */
	public Iterator<Vertex> adjVertexs(Vertex u);

	/**
	 * 深度优先遍历
	 * 
	 * @param v
	 * @return
	 */
	public Iterator<Vertex> DFSTraverse(Vertex v);

	/**
	 * 广度优先遍历
	 * 
	 * @param v
	 * @return
	 */
	public Iterator<Vertex> BFSTraverse(Vertex v);

	/**
	 * 求顶点v到其他顶点的最短路径
	 * 
	 * @param v
	 * @return
	 */
	public Iterator<Edge> shortestPath(Vertex v);

	/**
	 * 求无向图的最小生成树，无向图不支持此操作
	 * 
	 * @throws UnsupportOperation
	 *             无向图不支持此操作
	 */
	public void generateMST() throws UnsupportOperation;

	/**
	 * 求有向图的拓扑结构，无向图不支持此操作
	 * 
	 * @return
	 * @throws UnsupportOperation
	 *             无向图不支持此操作
	 */
	public Iterator<?> toplogicalSort() throws UnsupportOperation;

	/**
	 * 求有向无环图的关键路径，无向图不支持此操作
	 * 
	 * @throws UnsupportOperation
	 *             无向图不支持此操作
	 */
	public void criticalPath() throws UnsupportOperation;
}

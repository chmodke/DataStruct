package datastruct.implement;

import datastruct.exceptions.UnsupportOperation;
import datastruct.interfaces.Graph;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.LinkedList;

/**
 * @author kehao 无向图实现类
 */
public class UndirectedGraph extends AbstractGraph {

	public UndirectedGraph(int type) {
		super(Graph.UndirectedGraph);
	}

	@Override
	public void remove(Vertex v) {
		while (v.getDeg() > 0) {
			Edge e = v.getAdjacentEdges().first().getData();
			remove(e);
		}
		vertexs.remove(v.getVexPosition());
	}

	@Override
	public void remove(Edge e) {
		edges.remove(e.getEdgePosition());
		Vertex u = e.getFirstVex();
		Vertex v = e.getScondVex();
		u.getAdjacentEdges().remove(e.getEdgeFirstPosition());
		v.getAdjacentEdges().remove(e.getEdgeSecondPosition());
	}

	@Override
	public Edge edgeFromTo(Vertex u, Vertex v) {
		LinkedList<Edge> adjEdge = u.getAdjacentEdges();
		Iterator<Edge> it = adjEdge.elements();
		for (it.first(); !it.isDone(); it.next()) {
			Edge e = it.currentItem();
			if (v == e.getScondVex() || v == e.getFirstVex()) {
				return e;
			}
		}
		return null;
	}

	@Override
	public Iterator<Vertex> adjVertexs(Vertex u) {
		LinkedList<Vertex> adjVex = new LinkedListDLNode<Vertex>();
		LinkedList<Edge> adjEdge = u.getAdjacentEdges();
		Iterator<Edge> it = adjEdge.elements();
		for (it.first(); !it.isDone(); it.next()) {
			Edge e = it.currentItem();
			Vertex i = e.getFirstVex();
			Vertex j = e.getScondVex();
			if (u == i) {
				adjVex.insertLast(j);
			} else {
				adjVex.insertLast(i);
			}
		}
		return null;
	}

	@Override
	public void generateMST() {
		resetVexStatus();//重置图中各顶点的状态信息
		resetEdgeType();//重置图中各边的状态信息
		Iterator<Vertex> it = getVertex();
		Vertex v = it.currentItem();//选择第一个顶点作为起点
		v.setToVisited();
		//初始化顶点集合S到V-S各顶点的最短横切边
		for (it.first(); !it.isDone(); it.next()) {
			Vertex u = it.currentItem();
			Edge e = edgeFromTo(v, u);
			//设置到达V-S中顶点u的最短横切边
			setCrossEdge(u, e);
		}
		//进行V-1次循环找到|V|-1条边
		for (int t = 1; t < getVexNum(); t++) {
			Vertex k = selectMinVertex(it);//选择轻边在V-S中的顶点k
			k.setToVisited();//顶点k加入S
			Edge mst = getCrossEdge(k);//割(S，V-S)的轻边
			if (mst != null) {
				mst.setToMST();//将边加入MST
			}
			//以k为中间顶点修改S到V-S中顶点的最短横切边
			Iterator<Vertex> adjIt = adjVertexs(k);//取出k的所有邻接点
			for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
				Vertex adjV = adjIt.currentItem();
				Edge e = this.edgeFromTo(k, adjV);
				if (e.getWeight() < getCrossWeight(adjV)) {//发现到达ajdV更短的横切边
					setCrossEdge(adjV, e);
				}
			}
		}
	}

	/**
	 * 查找轻边在V-S中的顶点
	 * @param it
	 * @return
	 */
	protected Vertex selectMinVertex(Iterator<Vertex> it) {
		Vertex min = null;
		for (it.first(); !it.isDone(); it.next()) {
			Vertex v = it.currentItem();
			if (!v.isVisited()) {
				min = v;
				break;
			}
		}
		for (; !it.isDone(); it.next()) {
			Vertex v = it.currentItem();
			if (!v.isVisited() && getCrossWeight(v) < getCrossWeight(min)) {
				min = v;
			}
		}
		return min;
	}

	/**
	 * 求MST时，对v.application的操作
	 * @param v
	 * @return
	 */
	protected int getCrossWeight(Vertex v) {
		if (getCrossEdge(v) != null) {
			return getCrossEdge(v).getWeight();
		} else {
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * 获取到达顶点v的最小横切边
	 * @param v
	 * @return
	 */
	protected Edge getCrossEdge(Vertex v) {
		return (Edge) v.getApplication();
	}

	/**
	 * 设置到达顶点v的最小横切边
	 * @param v
	 * @param e
	 */
	protected void setCrossEdge(Vertex v, Edge e) {
		v.setApplication(e);
	}

	@Override
	public Iterator<Vertex> toplogicalSort() {
		throw new UnsupportOperation("无向图不支持生成拓扑结构操作");
	}

	@Override
	public void criticalPath() {
		throw new UnsupportOperation("无向图不支持查找环路关键路径操作");
	}

}

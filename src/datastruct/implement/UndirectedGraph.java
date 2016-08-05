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
		resetVexStatus();
		resetEdgeType();
		Iterator<Vertex> it = getVertex();
		Vertex v = it.currentItem();
		v.setToVisited();
		for (it.first(); !it.isDone(); it.next()) {
			Vertex u = it.currentItem();
			Edge e = edgeFromTo(v, u);
			setCrossEdge(u, e);
		}
		for (int t = 1; t < getVexNum(); t++) {
			Vertex k = selectMinVertex(it);
			k.setToVisited();
			Edge mst = getCrossEdge(k);
			if (mst != null) {
				mst.setToMST();
			}
			Iterator<Vertex> adjIt = adjVertexs(k);
			for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
				Vertex adjV = adjIt.currentItem();
				Edge e = this.edgeFromTo(k, adjV);
				if (e.getWeight() < getCrossWeight(adjV)) {
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

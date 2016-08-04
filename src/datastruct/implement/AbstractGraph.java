package datastruct.implement;

import datastruct.interfaces.Graph;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.Node;

/**
 * @author kehao
 * 图共有抽象类
 */
public abstract class AbstractGraph implements Graph {

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVexNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEdgeNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Vertex> getVertex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Edge> getEdge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<Vertex> insert(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<Edge> insert(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areAdjacent(Vertex u, Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Vertex> DFSTraverse(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Vertex> BFSTraverse(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Edge> shortestPath(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

}

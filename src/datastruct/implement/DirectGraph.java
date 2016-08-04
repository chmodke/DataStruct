package datastruct.implement;

import datastruct.exceptions.UnsupportOperation;
import datastruct.interfaces.Iterator;

/**
 * @author kehao
 * 有向图实现类
 */
public class DirectGraph extends AbstractGraph {

	@Override
	public void remove(Vertex v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Edge e) {
		// TODO Auto-generated method stub

	}

	@Override
	public Edge edgeFromTo(Vertex u, Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Vertex> adjVertexs(Vertex u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateMST() throws UnsupportOperation {
		throw new UnsupportOperation("有向图不支持最小生成树操作");
	}

	@Override
	public Iterator<?> toplogicalSort() throws UnsupportOperation {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criticalPath() throws UnsupportOperation {
		// TODO Auto-generated method stub
		
	}
}

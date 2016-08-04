package datastruct.implement;

import datastruct.exceptions.UnsupportOperation;
import datastruct.interfaces.Iterator;

/**
 * @author kehao
 * 无向图实现类
 */
public class UndirectedGraph extends AbstractGraph {

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<?> toplogicalSort() throws UnsupportOperation {
		throw new UnsupportOperation("无向图不支持生成拓扑结构操作");
	}

	@Override
	public void criticalPath() throws UnsupportOperation {
		throw new UnsupportOperation("无向图不支持查找环路关键路径操作");
	}

}

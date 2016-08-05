package datastruct.implement;

import datastruct.exceptions.UnsupportOperation;
import datastruct.interfaces.Graph;
import datastruct.interfaces.Iterator;
import datastruct.interfaces.LinkedList;

/**
 * @author kehao
 * 有向图实现类
 */
public class DirectGraph extends AbstractGraph {

	public DirectGraph(int type) {
		super(Graph.DirectedGraph);
	}

	@Override
	public void remove(Vertex v) {
		//将顶点从邻接边表中删除
		while(v.getOutDeg()>0){
			Edge e=v.getAdjacentEdges().first().getData();
			remove(e);
		}
		//将顶点从逆邻接边表中删除
		while(v.getOutDeg()>0){
			Edge e=v.getReAdjacentEdges().first().getData();
			remove(e);
		}
		//从顶点表中移出
		vertexs.remove(v.getVexPosition());
	}

	@Override
	public void remove(Edge e) {
		//从边表中删除
		edges.remove(e.getEdgePosition());
		Vertex v=e.getFirstVex();
		Vertex u=e.getScondVex();
		//将边从邻接节点边表中删除
		v.getAdjacentEdges().remove(e.getEdgeFirstPosition());
		//将边从逆邻接节点边表中删除
		u.getReAdjacentEdges().remove(e.getEdgeSecondPosition());
	}

	@Override
	public Edge edgeFromTo(Vertex u, Vertex v) {
		LinkedList<Edge> adjEdge=u.getAdjacentEdges();
		Iterator<Edge> it=adjEdge.elements();
		for(it.first();it.isDone();it.next()){
			Edge e=it.currentItem();
			if(e.getScondVex()==v){
				return e;
			}
		}
		return null;
	}

	@Override
	public Iterator<Vertex> adjVertexs(Vertex u) {
		LinkedList<Vertex> adjVex=new LinkedListDLNode<Vertex>();
		LinkedList<Edge> adjEdge=u.getAdjacentEdges();
		Iterator<Edge> it=adjEdge.elements();
		for(it.first();!it.isDone();it.next()){
			Edge e=it.currentItem();
			adjVex.insertLast(e.getScondVex());
		}
		return adjVex.elements();
	}

	@Override
	public void generateMST(){
		throw new UnsupportOperation("有向图不支持最小生成树操作");
	}

	@Override
	public Iterator<Vertex> toplogicalSort(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criticalPath(){
		// TODO Auto-generated method stub
		
	}
}

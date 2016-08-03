package datastruct.implement;

public class HuffmanTreeNode<E> extends BinTreeNode<E> {
	private int weight;//权值
	private String coding="";//编码
	public HuffmanTreeNode(int weight) {
		this(weight,null);
	}
	public HuffmanTreeNode(int weight, E e) {
		super(e);
		this.weight = weight;
	}
	@Override
	public HuffmanTreeNode<E> getParent() {
		return (HuffmanTreeNode<E>) super.getParent();
	}
	@Override
	public HuffmanTreeNode<E> getLChild() {
		return (HuffmanTreeNode<E>) super.getLChild();
	}
	@Override
	public HuffmanTreeNode<E> getRChild() {
		return (HuffmanTreeNode<E>) super.getRChild();
	}
	public int getWeight() {
		return weight;
	}
	public String getCoding() {
		return coding;
	}
	public void setCoding(String coding) {
		this.coding = coding;
	}
}

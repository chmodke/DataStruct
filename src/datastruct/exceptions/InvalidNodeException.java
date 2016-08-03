package datastruct.exceptions;

/**
 * @author KeHao
 * 非法节点异常
 */
public class InvalidNodeException extends RuntimeException {

	private static final long serialVersionUID = -4561292210754140258L;
	public InvalidNodeException(String err){
		super(err);
	}
}

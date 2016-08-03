package datastruct.exceptions;

/**
 * @author KeHao
 * 下标越界异常
 */
public class OutOfBoundaryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OutOfBoundaryException(String err){
		super(err);
	}
}

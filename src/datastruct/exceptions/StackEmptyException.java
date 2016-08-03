package datastruct.exceptions;

/**
 * @author KeHao
 * 堆栈空异常
 */
public class StackEmptyException extends RuntimeException {
	private static final long serialVersionUID = -3878511303245478192L;

	public StackEmptyException(String message) {
		super(message);
	}
}

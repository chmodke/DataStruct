package datastruct.exceptions;

/**
 * @author KeHao
 * 队列为空异常
 */
public class QueueEmptyException extends RuntimeException {

	private static final long serialVersionUID = 3698848098063781610L;

	public QueueEmptyException(String message) {
		super(message);
	}

}

package datastruct.exceptions;

public class UnsupportOperation extends RuntimeException {
	private static final long serialVersionUID = -4748007726915784131L;

	public UnsupportOperation(String err) {
		super(err);
	}
}

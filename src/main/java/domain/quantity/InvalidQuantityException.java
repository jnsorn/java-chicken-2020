package domain.quantity;

public class InvalidQuantityException extends IllegalArgumentException {
	static final String WRONG_TYPE = "숫자를 입력하세요.";
	static final String WRONG_BOUNDS = "1~99사이를 입력해주세요.";

	public InvalidQuantityException(String s) {
		super(s);
	}
}

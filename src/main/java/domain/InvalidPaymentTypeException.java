package domain;

public class InvalidPaymentTypeException extends IllegalArgumentException {
	static final String INVALID_PAYMENT_TYPE = "1 혹은 2를 입력해주세요.";

	public InvalidPaymentTypeException(String s) {
		super(s);
	}
}

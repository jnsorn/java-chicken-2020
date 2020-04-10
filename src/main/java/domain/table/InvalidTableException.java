package domain.table;

public class InvalidTableException extends IllegalArgumentException {
	static final String WRONG_TYPE = "숫자를 입력하세요.";
	static final String INVALID_TABLE_NUMBER = "유효한 테이블 넘버가 아닙니다.";

	public InvalidTableException(String s) {
		super(s);
	}
}

package domain;

public class InvalidCommandException extends IllegalArgumentException {
	public static final String INVALID_COMMAND = "유효하지 않은 명령어입니다.";

	public InvalidCommandException(String s) {
		super(s);
	}
}

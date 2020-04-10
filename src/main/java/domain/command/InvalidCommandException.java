package domain.command;

public class InvalidCommandException extends IllegalArgumentException {
	static final String INVALID_COMMAND = "유효하지 않은 명령어입니다.";

	public InvalidCommandException(String s) {
		super(s);
	}
}

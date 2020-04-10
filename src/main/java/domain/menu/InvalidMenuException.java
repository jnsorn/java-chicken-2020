package domain.menu;

public class InvalidMenuException extends IllegalArgumentException {
	static final String WRONG_TYPE = "메뉴 넘버를 입력하세요.";
	static final String INVALID_MENU_NUMBER = "존재하지 않는 메뉴입니다.";

	public InvalidMenuException(String s) {
		super(s);
	}
}

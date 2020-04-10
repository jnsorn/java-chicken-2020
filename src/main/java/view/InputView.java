package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static String inputAction() {
		System.out.println("## 메인화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료");
		return scanner.nextLine();
	}

	public static String inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return scanner.nextLine();
	}

	public static String inputMenu() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		return scanner.nextLine();
	}

	public static String inputQuantity() {
		System.out.println("## 메뉴의 수량을 입력하세요.");
		return scanner.nextLine();
	}
}

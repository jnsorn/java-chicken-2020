package view;

import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.menu.Menu;
import domain.quantity.Quantity;
import domain.table.Table;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_LINE_WITH_WON = "└ \\ ┘";
	private static final String BLANK = " ";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printBottomLine(tables);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printBottomLine(final List<Table> tables) {
		for (Table table : tables) {
			String line = selectLine(table);
			System.out.print(line);
		}
		System.out.println();
	}

	private static String selectLine(Table table) {
		if (table.hasOrder()) {
			return BOTTOM_LINE_WITH_WON;
		}
		return BOTTOM_LINE;
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printOrder(Table table) {
		System.out.println("## 주문 내역");
		System.out.println("## 메뉴 수량 금액");
		Set<Map.Entry<Menu, Quantity>> orders = table.getOrder().getOrder().entrySet();
		orders.forEach(order ->
			System.out.println(
				order.getKey().getName() + BLANK +
					order.getValue().getNumber() + BLANK +
					order.getKey().getPrice()
			)
		);
	}

	public static void printBill(double bill) {
		System.out.println("## 최종 결제할 금액");
		System.out.println(bill + "원");
	}
}

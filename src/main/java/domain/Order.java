package domain;

import java.util.HashMap;
import java.util.Map;

import domain.menu.Menu;
import domain.quantity.Quantity;

public class Order {
	private static final int NOT_EXIST = 0;
	private Map<Menu, Quantity> order;

	public Order() {
		order = new HashMap<>();
	}

	public void add(Menu menu, Quantity quantity) {
		order.computeIfPresent(menu, (Menu key, Quantity value) -> quantity.plus(value));
	}

	public boolean isExist() {
		return order.size() != NOT_EXIST;
	}
}

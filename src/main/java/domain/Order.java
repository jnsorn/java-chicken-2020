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
		if (order.containsKey(menu)) {
			quantity = order.get(menu).plus(quantity);
		}
		order.put(menu, quantity);
	}

	public boolean isExist() {
		return order.size() != NOT_EXIST;
	}
}

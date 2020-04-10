package domain;

import java.util.Map;

import domain.menu.Menu;
import domain.quantity.Quantity;

public class Order {
	private Map<Menu, Quantity> order;

	public Order() {

	}

	public void add(Menu menu, Quantity quantity) {
		order.computeIfPresent(menu, (Menu key, Quantity value) -> quantity.plusOne());
	}
}

package domain.table;

import domain.Order;
import domain.menu.Menu;
import domain.quantity.Quantity;

public class Table {
	private final int number;
	private Order order;

	public Table(final int number) {
		this.number = number;
		order = new Order();
	}

	public void order(Menu menu, Quantity quantity) {
		order.add(menu, quantity);
	}

	public boolean hasOrder(){
		return order.isExist();
	}

	public boolean isEquals(String tableNumber) {
		int number;
		try {
			number = Integer.parseInt(tableNumber);
		} catch (NumberFormatException e) {
			throw new InvalidTableException(InvalidTableException.WRONG_TYPE);
		}
		return this.number == number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}

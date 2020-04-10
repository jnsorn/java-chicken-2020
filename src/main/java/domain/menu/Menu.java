package domain.menu;

import domain.Category;

public class Menu {
	private final int number;
	private final String name;
	private final Category category;
	private final int price;

	public Menu(final int number, final String name, final Category category, final int price) {
		this.number = number;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public boolean isEquals(String menuNumber) {
		int number;
		try {
			number = Integer.parseInt(menuNumber);
		} catch (NumberFormatException e) {
			throw new InvalidMenuException(InvalidMenuException.WRONG_TYPE);
		}
		return this.number == number;
	}

	@Override
	public String toString() {
		return category + " " + number + " - " + name + " : " + price + "원";
	}
}

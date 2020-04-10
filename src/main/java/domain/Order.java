package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import domain.menu.Menu;
import domain.quantity.Quantity;

public class Order {
	private static final int NOT_EXIST = 0;
	private static final int MIN_COUNT_FOR_DISCOUNT = 10;
	private static final int DISCOUNT_UNIT = 10000;
	private static final int DEFAULT_VALUE = 1;

	private Map<Menu, Quantity> order;
	private Map<Category, Integer> groupByCategory;

	public Order() {
		order = new HashMap<>();
		groupByCategory = new HashMap<>();
	}

	public void add(Menu menu, Quantity quantity) {
		if (order.containsKey(menu)) {
			quantity = order.get(menu).plus(quantity);
		}
		order.put(menu, quantity);

		updateCategoryCount(menu, quantity);
	}

	private void updateCategoryCount(Menu menu, Quantity quantity) {
		Category category = menu.getCategory();
		int count = quantity.getNumber();

		if (groupByCategory.containsKey(category)) {
			count = groupByCategory.get(category) + count;
		}
		groupByCategory.put(category, count);
	}

	public boolean isExist() {
		return order.size() != NOT_EXIST;
	}

	public double calculatePrice(PaymentType paymentType) {
		Set<Map.Entry<Menu, Quantity>> entry = order.entrySet();
		int originalPrice = calculateOriginalPrice(entry);
		double price = applyCategoryDiscount(originalPrice);
		return paymentType.applyPaymentTypeDiscout(price);
	}

	private double applyCategoryDiscount(int price) {
		int count = groupByCategory.getOrDefault(Category.CHICKEN, DEFAULT_VALUE);
		if (count < MIN_COUNT_FOR_DISCOUNT) {
			return price;
		}
		int discountMoney = (count / MIN_COUNT_FOR_DISCOUNT) * DISCOUNT_UNIT;
		return price - discountMoney;
	}

	private int calculateOriginalPrice(Set<Map.Entry<Menu, Quantity>> entry) {
		int bill = 0;
		for (Map.Entry<Menu, Quantity> value : entry) {
			Menu menu = value.getKey();
			Quantity quantity = value.getValue();
			bill += menu.getPrice() * quantity.getNumber();
		}
		return bill;
	}

	public Map<Menu, Quantity> getOrder() {
		return order;
	}
}

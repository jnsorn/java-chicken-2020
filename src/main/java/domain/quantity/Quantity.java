package domain.quantity;

public class Quantity {
	private static final int MINIMUM_QUANTITY = 0;
	private static final int MAXIMUM_QUANTITY = 99;
	private int quantity;

	public Quantity(String inputQuantity) {
		validateType(inputQuantity);
		int quantity = Integer.parseInt(inputQuantity);
		validateBounds(quantity);
		this.quantity = quantity;
	}

	private void validateType(String quantity) {
		try {
			Integer.parseInt(quantity);
		} catch (NumberFormatException e) {
			throw new InvalidQuantityException(InvalidQuantityException.WRONG_TYPE);
		}
	}

	private void validateBounds(int quantity) {
		if (MINIMUM_QUANTITY > quantity || MAXIMUM_QUANTITY < quantity) {
			throw new InvalidQuantityException(InvalidQuantityException.WRONG_BOUNDS);
		}
	}
}

package domain.table;

public class Table {
	private final int number;

	public Table(final int number) {
		this.number = number;
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

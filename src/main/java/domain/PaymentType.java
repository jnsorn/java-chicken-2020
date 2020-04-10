package domain;

import java.util.Arrays;

public enum PaymentType {
	CASH("2", 0.95),
	CARD("1", 1.0);

	private String type;
	private double payRate;

	PaymentType(String type, double payRate) {
		this.type = type;
		this.payRate = payRate;
	}

	public static PaymentType of(String inputType) {
		return Arrays.stream(values())
			.filter(paymentType -> paymentType.type.equals(inputType))
			.findFirst()
			.orElseThrow(() -> new InvalidPaymentTypeException(InvalidPaymentTypeException.INVALID_PAYMENT_TYPE));
	}

	public double applyPaymentTypeDiscout(double originalPrice) {
		return this.payRate * (double)originalPrice;
	}
}

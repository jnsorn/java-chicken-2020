package domain.quantity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuantityTest {

	@Test
	void plus() {
		Quantity quantity = new Quantity("1");
		quantity.plus(new Quantity("3"));
		assertThat(quantity.getNumber()).isEqualTo("4");
	}

	@Test
	void getNumber() {
	}
}
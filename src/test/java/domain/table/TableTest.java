package domain.table;

import static domain.PaymentType.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.menu.MenuRepository;
import domain.quantity.Quantity;

class TableTest {
	Table table;

	@BeforeEach
	void setUp() {
		table = TableRepository.of("1");
	}

	@Test
	void order() {
		table.order(MenuRepository.of("1"), new Quantity("1"));
		assertThat(table.getOrder().isExist()).isTrue();
	}

	@Test
	void pay() {
		assertThat(table.pay(CARD)).isEqualTo(0.0);
	}

	@Test
	void hasOrder() {
		assertThat(table.hasOrder()).isFalse();
	}

	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true"})
	void isEquals(String tableNumber, boolean expected) {
		Table table = TableRepository.of(tableNumber);
		assertThat(table.isEquals(tableNumber)).isEqualTo(expected);
	}
}
package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {

	@ParameterizedTest
	@CsvSource({"1,true", "2,true", "3,true"})
	void isEquals(String menuNumber, boolean expected) {
		Menu menu = MenuRepository.of(menuNumber);
		assertThat(menu.isEquals(menuNumber)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({"1,후라이드", "2,양념치킨", "3,반반치킨"})
	void getName(String menuNumber, String name) {
		Menu menu = MenuRepository.of(menuNumber);
		assertThat(menu.getName()).isEqualTo(name);
	}

	@ParameterizedTest
	@CsvSource({"1,CHICKEN", "22,BEVERAGE"})
	void getCategory(String menuNumber, Category category) {
		Menu menu = MenuRepository.of(menuNumber);
		assertThat(menu.getCategory()).isEqualTo(category);
	}
}
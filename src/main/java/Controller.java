import java.util.List;

import domain.command.Command;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.quantity.Quantity;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

public class Controller {
	public void run() {
		Command command = Command.of(InputView.inputAction());

		if (command.isTerminate()) {
			System.exit(0);
		}

		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();

		if (command.isOrder()) {
			order();
		}

		if (command.isPay()) {
			// TODO: 2020-04-10 결제는 전략?
		}
	}

	private void order() {
		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
		// TODO: 2020-04-10 order로 감싸자
		Menu menu = MenuRepository.of(InputView.inputMenu());
		Quantity quantity = new Quantity(InputView.inputQuantity());
	}
}

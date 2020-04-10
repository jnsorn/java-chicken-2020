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
	public void start() {
		while (true) {
			run();
		}
	}

	private void run() {
		Command command = Command.of(InputView.inputAction());

		if (command.isTerminate()) {
			System.exit(0);
		}

		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		Table table = TableRepository.of(InputView.inputTableNumber());

		if (command.isOrder()) {
			order(table);
		}

		if (command.isPay()) {
		}
	}

	private void order(Table table) {
		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
		Menu menu = MenuRepository.of(InputView.inputMenu());
		Quantity quantity = new Quantity(InputView.inputQuantity());
		table.order(menu, quantity);
	}
}

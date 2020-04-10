import java.util.List;

import domain.Command;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Controller {
	public void run() {
		OutputView.printAction();
		Command command = Command.of(InputView.inputAction());

		if (command.isTerminate()) {
			System.exit(0);
		}

		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);

		final int tableNumber = InputView.inputTableNumber();

		if (command.isOrder()) {
			final List<Menu> menus = MenuRepository.menus();
			OutputView.printMenus(menus);
		}

		if (command.isPay()) {
		}
	}
}

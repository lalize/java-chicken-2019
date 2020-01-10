package domain;

import java.util.List;

import view.InputView;
import view.OutputView;

public class OrderFunction implements Function {
	@Override
	public void call() {
		final Table table = selectTable();
		final Menu menu = selectMenu();
	}

	private Table selectTable() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();
		return TableRepository.valueOf(tableNumber);
	}

	private Menu selectMenu() {
		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
		final int menuNumber = InputView.inputMenuNumber();
		return MenuRepository.valueOf(menuNumber);
	}
}

package domain;

import java.util.List;

import view.InputView;
import view.OutputView;

public class PaymentFunction implements Function {
	@Override
	public void call() {
		final Table table = selectTable();
		OutputView.printOrders(table.orders());
	}

	private Table selectTable() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();
		return TableRepository.valueOf(tableNumber);
	}
}

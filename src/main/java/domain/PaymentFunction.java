package domain;

import java.util.List;

import view.InputView;
import view.OutputView;

public class PaymentFunction implements Function {
	@Override
	public void call() {
		try {
			final Table table = selectTable();
			OutputView.printOrders(table.orders());
			final Payment payment = selectPayment(table);
			final int price = table.payment(payment);
			OutputView.printPrice(price);
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}

	private Table selectTable() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();
		return TableRepository.valueOf(tableNumber);
	}

	private Payment selectPayment(final Table table) {
		final int paymentNumber = InputView.inputPaymentNumber(table.getNumber());
		return Payment.valueOf(paymentNumber);
	}
}

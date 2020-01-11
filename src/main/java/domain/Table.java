package domain;

import java.util.Collection;

public class Table {
	private final int number;
	private final Orders orders = new Orders();

	public Table(final int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public boolean isNumber(final int number) {
		return this.number == number;
	}

	public void addOrder(Menu menu, Quantity quantity) {
		orders.add(menu, quantity);
	}

	public boolean hasOrder() {
		return !orders.isEmpty();
	}

	public boolean hasNotOrder() {
		return orders.isEmpty();
	}

	public Collection<Order> orders() {
		return orders.orders();
	}

	public int getNumber() {
		return number;
	}

	private void clearOrders() {
		orders.clear();
	}

	public int payment(Payment payment) {
		if (hasNotOrder()) {
			throw new IllegalStateException("주문이 존재하지 않습니다.");
		}
		final int price = payment.calculate(orders.price());
		clearOrders();
		return price;
	}
}

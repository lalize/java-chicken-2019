package domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class Orders {
	private final Hashtable<Menu, Order> orders = new Hashtable<>();

	public void add(final Menu menu, final Quantity quantity) {
		final Order order = orders.get(menu);
		if (order == null) {
			orders.put(menu, new Order(menu, quantity));
			return;
		}
		order.addQuantity(quantity);
	}

	public Collection<Order> orders() {
		return Collections.unmodifiableCollection(orders.values());
	}

	public boolean isEmpty() {
		return orders.isEmpty();
	}

	public void clear() {
		orders.clear();
	}

	public int price() {
		return orders.values()
				.stream()
				.mapToInt(Order::price)
				.sum();
	}
}

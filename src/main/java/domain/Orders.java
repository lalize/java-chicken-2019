package domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class Orders {
	private final Hashtable<Menu, Order> orders = new Hashtable<>();

	public void add(Menu menu, Quantity quantity) {
		final Order order = orders.get(menu);
		if (order == null) {
			orders.put(menu, new Order(menu, quantity));
			return;
		}
		order.addQuantity(quantity);
	}

	public Collection<Order> get() {
		return Collections.unmodifiableCollection(orders.values());
	}

	public boolean isNotEmpty() {
		return !orders.isEmpty();
	}

	public void clear() {
		orders.clear();
	}

	public int getPrice() {
		return orders.values()
				.stream()
				.mapToInt(Order::getPrice)
				.sum();
	}
}

package domain;

import java.util.Hashtable;

public class Orders {
	private final Hashtable<Menu, Quantity> orders = new Hashtable<>();

	public void add(Menu menu, Quantity quantity) {
		final Quantity orderQuantity = orders.get(menu);
		if (orderQuantity == null) {
			orders.put(menu, quantity);
			return;
		}
		orders.put(menu, orderQuantity.add(quantity));
	}
}

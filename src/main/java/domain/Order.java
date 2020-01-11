package domain;

public class Order {
	private static final int CHICKEN_DISCOUNT_UNIT = 10;
	private static final int CHICKEN_DISCOUNT_PRICE = 10_000;
	private static final int ZERO = 0;

	private final Menu menu;
	private Quantity quantity;

	public Order(final Menu menu, final Quantity quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}

	public void addQuantity(final Quantity quantity) {
		this.quantity = this.quantity.add(quantity);
	}

	@Override
	public String toString() {
		return menu.getName() + " " + quantity.get() + " " + getPrice();
	}

	private int discount() {
		if (menu.isChicken()) {
			return quantity.get() / CHICKEN_DISCOUNT_UNIT * CHICKEN_DISCOUNT_PRICE;
		}
		return ZERO;
	}

	public int getPrice() {
		return menu.getPrice() * quantity.get() - discount();
	}
}

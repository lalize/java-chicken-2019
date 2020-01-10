package domain;

public class Order {
	private static final int CHICKEN_DISCOUNT_UNIT = 10;
	private static final int CHICKEN_DISCOUNT_PRICE = 10_000;

	private final Menu menu;
	private Quantity quantity;

	public Order(final Menu menu, final Quantity quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}

	public void addQuantity(final Quantity quantity) {
		final Quantity newQuantity = this.quantity.add(quantity);
		this.quantity = newQuantity;
	}

	@Override
	public String toString() {
		return menu.getName() + " " + quantity.get() + " " + getPrice();
	}

	public int getPrice() {
		final int price = menu.getPrice() * quantity.get();
		if (menu.isChicken()) {
			final int discount = quantity.get() / CHICKEN_DISCOUNT_UNIT * CHICKEN_DISCOUNT_PRICE;
			return price - discount;
		}
		return price;
	}
}

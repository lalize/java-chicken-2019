package domain;

public class Order {
	private static final int CHICKEN_SALE_UNIT = 10;
	private static final int CHICKEN_SALE_PRICE = 10000;

	private final Menu menu;
	private final Amount amount;

	public Order(Menu menu, Amount amount) {
		this.menu = menu;
		this.amount = amount;
	}

	public String menu() {
		return menu.getName();
	}

	public int amount() {
		return amount.get();
	}

	public int price() {
		return menu.getPrice() * amount();
	}

	public int realPrice() {
		if (menu.isChicken()) {
			int saleUnit = amount() / CHICKEN_SALE_UNIT;
			int salePrice = saleUnit * CHICKEN_SALE_PRICE;
			return price() - salePrice;
		}
		return price();
	}
}

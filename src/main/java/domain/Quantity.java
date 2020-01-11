package domain;

public class Quantity {
	private static final int MIN = 0;
	private static final int MAX = 99;

	private final int quantity;

	public Quantity(final int quantity) {
		validate(quantity);
		this.quantity = quantity;
	}

	public static Quantity valueOf(final int quantity) {
		return new Quantity(quantity);
	}

	private void validate(final int quantity) {
		if (quantity < MIN || quantity > MAX) {
			throw new IllegalArgumentException("수량은 0 이상 99까지 입니다.");
		}
	}

	public int get() {
		return quantity;
	}

	public Quantity add(final Quantity quantity) {
		return new Quantity(this.quantity + quantity.get());
	}
}

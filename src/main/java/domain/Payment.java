package domain;

import java.util.Arrays;
import java.util.function.Function;

public enum Payment {
	CREDIT_CARD(1, value -> value),
	CASH(2, value -> (int)(value * 0.95));

	private final int number;
	private final Function<Integer, Integer> expression;

	Payment(final int number, final Function<Integer, Integer> expression) {
		this.number = number;
		this.expression = expression;
	}

	public static Payment valueOf(final int number) {
		return Arrays.stream(values())
				.filter(payment -> payment.number == number)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 지불방식입니다."));
	}

	public int calculate(final int price) {
		return expression.apply(price);
	}
}

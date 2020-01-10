package domain;

import java.util.Arrays;

public enum FunctionType {
	ORDER(1),
	PAYMENT(2),
	QUIT(3);

	private final int number;

	FunctionType(final int number){
		this.number = number;
	}

	public static FunctionType valueOf(final int number) {
		return Arrays.stream(values())
				.filter(function -> function.number == number)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기능입니다."));
	}
}

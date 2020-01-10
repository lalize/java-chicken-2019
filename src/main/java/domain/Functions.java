package domain;

import java.util.HashMap;

public class Functions {
	private static final HashMap<FunctionType, Function> functions = new HashMap<>();

	static {
		functions.put(FunctionType.ORDER, new OrderFunction());
		functions.put(FunctionType.PAYMENT, new PaymentFunction());
		functions.put(FunctionType.QUIT, new QuitFunction());
	}

	public static Function get(FunctionType type) {
		return functions.get(type);
	}
}

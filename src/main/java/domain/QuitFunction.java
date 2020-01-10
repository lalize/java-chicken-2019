package domain;

public class QuitFunction implements Function {
	private static final int CLEAN = 0;

	@Override
	public void call() {
		System.exit(CLEAN);
	}
}

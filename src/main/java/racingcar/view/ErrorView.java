package racingcar.view;

public class ErrorView {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static void show(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}

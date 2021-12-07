package racingcar.exception;

public class ErrorMessage {
	private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

	public static void print(String message) {
		System.out.println(ERROR_MESSAGE_PREFIX + message);
	}
}

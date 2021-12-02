package racingcar.io;

public class ConsoleDisplay {
	private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

	public void info(String message) {
		System.out.println(message);
	}

	public void error(String message) {
		System.out.println(ERROR_MESSAGE_PREFIX + message);
	}
}

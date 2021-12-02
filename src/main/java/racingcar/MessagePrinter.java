package racingcar;

public class MessagePrinter {

	public static void printError(IllegalArgumentException exception) {
		System.out.println("[ERROR] " + exception.getMessage());
	}

}

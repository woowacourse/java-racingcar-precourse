package racingcar;

public class TurnValueReader {
	public static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	private final ConsoleDisplay consoleDisplay;

	public TurnValueReader(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public int read() {
		consoleDisplay.info(INPUT_MESSAGE);
		return 0;
	}
}

package racingcar;

public class TurnValueReader extends Reader<Integer>{
	public static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	public TurnValueReader(ConsoleDisplay consoleDisplay) {
		super(consoleDisplay, INPUT_MESSAGE, "");
	}

	@Override
	protected boolean isValid(String result) {
		return true;
	}

	@Override
	protected Integer handleInputValue(String input) {
		return Integer.valueOf(input);
	}
}

package racingcar;

public class TurnValueReader extends Reader<Integer>{
	public static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

	public TurnValueReader(ConsoleDisplay consoleDisplay) {
		super(consoleDisplay, INPUT_MESSAGE, ERROR_MESSAGE);
	}

	@Override
	protected boolean isValid(String result) {
		return result.matches("[0-9]*");
	}

	@Override
	protected Integer handleInputValue(String input) {
		return Integer.valueOf(input);
	}
}

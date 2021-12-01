package racingcar.reader;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ConsoleDisplay;

public abstract class Reader<T> {
	private final ConsoleDisplay consoleDisplay;
	private final String inputMessage;
	private final String errorMessage;

	public Reader(ConsoleDisplay consoleDisplay, String inputMessage, String errorMessage) {
		this.consoleDisplay = consoleDisplay;
		this.inputMessage = inputMessage;
		this.errorMessage = errorMessage;
	}

	public T read() {
		consoleDisplay.info(inputMessage);
		String input = Console.readLine();

		if(!isValid(input)) {
			throw new IllegalArgumentException(errorMessage);
		}

		return handleInputValue(Console.readLine());
	}

	protected abstract boolean isValid(String input);
	protected abstract T handleInputValue(String input);
}

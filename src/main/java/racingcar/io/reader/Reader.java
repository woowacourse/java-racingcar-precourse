package racingcar.io.reader;

import camp.nextstep.edu.missionutils.Console;

import racingcar.io.ConsoleDisplay;

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

		if (!isValid(input)) {
			consoleDisplay.error(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}

		return handleInputValue(input);
	}

	protected abstract boolean isValid(String input);

	protected abstract T handleInputValue(String input);
}

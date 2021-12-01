package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
		T result = handleInputValue(Console.readLine());

		if(!isValid(result)) {
			throw new IllegalArgumentException(errorMessage);
		}

		return result;
	}

	protected abstract boolean isValid(T result);
	protected abstract T handleInputValue(String input);
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;

public abstract class Reader<T> {
	private final ConsoleDisplay consoleDisplay;
	private final String inputMessage;

	public Reader(ConsoleDisplay consoleDisplay, String inputMessage) {
		this.consoleDisplay = consoleDisplay;
		this.inputMessage = inputMessage;
	}

	public T read() {
		consoleDisplay.info(inputMessage);
		return handleInputValue(Console.readLine());
	}

	protected abstract T handleInputValue(String input);
}

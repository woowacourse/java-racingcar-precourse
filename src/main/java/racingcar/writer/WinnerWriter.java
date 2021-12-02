package racingcar.writer;

import racingcar.ConsoleDisplay;

public class WinnerWriter {
	private ConsoleDisplay consoleDisplay;

	public WinnerWriter(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public void write(String winner) {
		consoleDisplay.info("최종 우승자 : " + winner);
	}
}

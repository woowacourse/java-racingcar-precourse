package racingcar.io.writer;

import static java.util.stream.Collectors.joining;

import java.util.List;

import racingcar.io.ConsoleDisplay;

public class WinnerWriter {
	private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
	private ConsoleDisplay consoleDisplay;

	public WinnerWriter(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public void write(List<String> winners) {
		consoleDisplay.info(WINNER_MESSAGE_PREFIX + joiningWithComma(winners));
	}

	private String joiningWithComma(List<String> winners) {
		return winners.stream().collect(joining(", "));
	}
}

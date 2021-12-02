package racingcar.io.writer;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.io.ConsoleDisplay;

public class WinnerWriter {
	private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
	private ConsoleDisplay consoleDisplay;

	public WinnerWriter(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public void write(List<String> winners) {
		String result = winners.stream().collect(Collectors.joining(", "));
		consoleDisplay.info(WINNER_MESSAGE_PREFIX + result);
	}
}

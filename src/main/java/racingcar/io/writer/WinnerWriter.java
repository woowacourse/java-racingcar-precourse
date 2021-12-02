package racingcar.io.writer;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.io.ConsoleDisplay;

public class WinnerWriter {
	private ConsoleDisplay consoleDisplay;

	public WinnerWriter(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public void write(List<String> winners) {
		String result = winners.stream().collect(Collectors.joining(", "));
		consoleDisplay.info("최종 우승자 : " + result);
	}
}

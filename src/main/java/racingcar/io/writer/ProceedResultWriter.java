package racingcar.io.writer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.io.ConsoleDisplay;
import racingcar.model.ProceedResult;

public class ProceedResultWriter {
	private static final String PROGRESS_BAR = "-";
	private static final String DELIMITER = " : ";
	private final ConsoleDisplay consoleDisplay;

	public ProceedResultWriter(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public void write(List<ProceedResult> proceedResults) {
		for (ProceedResult result : proceedResults) {
			write(result);
		}
		writeBlankLine();
	}

	private void write(ProceedResult result) {
		consoleDisplay.info(result.getName() + DELIMITER + progressBar(result.getPosition()));
	}

	private String progressBar(int position) {
		return IntStream.range(0, position).mapToObj(i -> PROGRESS_BAR).collect(Collectors.joining());
	}

	private void writeBlankLine() {
		consoleDisplay.info("");
	}
}

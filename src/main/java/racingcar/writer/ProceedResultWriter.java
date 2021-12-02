package racingcar.writer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.ConsoleDisplay;
import racingcar.model.ProceedResult;

public class ProceedResultWriter {
	private final ConsoleDisplay consoleDisplay;

	public ProceedResultWriter(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public void write(List<ProceedResult> proceedResults) {
		for(ProceedResult result : proceedResults) {
			write(result);
		}
		consoleDisplay.info("");
	}

	private void write(ProceedResult result) {
		consoleDisplay.info(result.getName() + " : " + progressBar(result.getPosition()));
	}

	private String progressBar(int position) {
		return IntStream.range(0, position).mapToObj(i -> "-").collect(Collectors.joining());
	}
}

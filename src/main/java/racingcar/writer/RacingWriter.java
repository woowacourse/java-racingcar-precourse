package racingcar.writer;

import java.util.List;
import racingcar.model.ProceedResult;

public class RacingWriter {
	private final ProceedResultWriter proceedResultWriter;
	private final WinnerWriter winnerWriter;

	public RacingWriter(ProceedResultWriter proceedResultWriter, WinnerWriter winnerWriter) {
		this.proceedResultWriter = proceedResultWriter;
		this.winnerWriter = winnerWriter;
	}

	public void writeProceedResults(List<ProceedResult> proceedResults) {
		proceedResultWriter.write(proceedResults);
	}

	public void writeWinners(List<String> winners) {
		winnerWriter.write(winners);
	}
}

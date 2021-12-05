package racingcar;

import java.util.List;

import racingcar.model.ProceedResult;
import racingcar.model.RacingGame;
import racingcar.model.RacingInfo;
import racingcar.io.reader.RacingReader;
import racingcar.io.writer.RacingWriter;

public class RacingGameManager {
	private final RacingReader reader;
	private final RacingWriter writer;

	public RacingGameManager(RacingReader reader, RacingWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void run() {
		RacingInfo info = reader.read();
		RacingGame racingGame = RacingGame.of(info);

		while (!racingGame.isFinished()) {
			List<ProceedResult> proceedResults = racingGame.proceed();
			writer.writeProceedResults(proceedResults);
		}

		List<String> winners = racingGame.getWinners();
		writer.writeWinners(winners);
	}
}

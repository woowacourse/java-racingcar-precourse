package racingcar;

import racingcar.reader.CarNameReader;
import racingcar.reader.RacingInfoReader;
import racingcar.reader.TurnValueReader;
import racingcar.writer.ProceedResultWriter;
import racingcar.writer.RacingWriter;
import racingcar.writer.WinnerWriter;

public class Application {
	public static void main(String[] args) {
		ConsoleDisplay consoleDisplay = new ConsoleDisplay();
		RacingGameManager racingGameManager = new RacingGameManager(
			new RacingInfoReader(new CarNameReader(consoleDisplay), new TurnValueReader(consoleDisplay)),
			new RacingWriter(new ProceedResultWriter(consoleDisplay), new WinnerWriter(consoleDisplay)));
		racingGameManager.run();
	}
}

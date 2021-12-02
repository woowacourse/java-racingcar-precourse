package racingcar;

import racingcar.io.ConsoleDisplay;
import racingcar.io.reader.CarNameReader;
import racingcar.io.reader.RacingInfoReader;
import racingcar.io.reader.TurnValueReader;
import racingcar.io.writer.ProceedResultWriter;
import racingcar.io.writer.RacingWriter;
import racingcar.io.writer.WinnerWriter;

public class Application {
	public static void main(String[] args) {
		ConsoleDisplay consoleDisplay = new ConsoleDisplay();
		RacingGameManager racingGameManager = new RacingGameManager(
			new RacingInfoReader(new CarNameReader(consoleDisplay), new TurnValueReader(consoleDisplay)),
			new RacingWriter(new ProceedResultWriter(consoleDisplay), new WinnerWriter(consoleDisplay)));
		racingGameManager.run();
	}
}

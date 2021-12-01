package racingcar;

import java.util.List;
import racingcar.reader.CarNameReader;
import racingcar.reader.TurnValueReader;

public class RacingGameManager {
	private final ConsoleDisplay consoleDisplay;
	private final CarNameReader carNameReader;
	private final TurnValueReader turnValueReader;

	public RacingGameManager(ConsoleDisplay consoleDisplay, CarNameReader carNameReader,
	                         TurnValueReader turnValueReader) {
		this.consoleDisplay = consoleDisplay;
		this.carNameReader = carNameReader;
		this.turnValueReader = turnValueReader;
	}

	public void read() {
		List<String> carNames = carNameReader.read();
		int turnValue = turnValueReader.read();
	}
}

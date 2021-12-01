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
		List<String> carNames = readCarNames();
		int turnValue = readTurnValue();
	}

	private List<String> readCarNames() {
		try {
			return carNameReader.read();
		} catch (IllegalArgumentException e) {
			consoleDisplay.info(e.getMessage());
			return readCarNames();
		}
	}

	private Integer readTurnValue() {
		try {
			return turnValueReader.read();
		} catch (IllegalArgumentException e) {
			consoleDisplay.info(e.getMessage());
			return readTurnValue();
		}
	}
}

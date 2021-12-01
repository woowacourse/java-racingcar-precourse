package racingcar.reader;

import java.util.List;
import racingcar.ConsoleDisplay;

public class RacingInfoReader {
	private final Reader<List<String>> carNameReader;
	private final Reader<Integer> turnValueReader;

	public RacingInfoReader(ConsoleDisplay consoleDisplay) {
		this.carNameReader = new CarNameReader(consoleDisplay);
		this.turnValueReader = new TurnValueReader(consoleDisplay);
	}

	public RacingInfo read() {
		List<String> carNames = readCarNames();
		Integer turnValue = readTurnValue();
		return RacingInfo.of(turnValue, carNames);
	}

	private List<String> readCarNames() {
		try {
			return carNameReader.read();
		} catch (IllegalArgumentException e) {
			return readCarNames();
		}
	}

	private Integer readTurnValue() {
		try {
			return turnValueReader.read();
		} catch (IllegalArgumentException e) {
			return readTurnValue();
		}
	}
}

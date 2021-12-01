package racingcar;

import java.util.List;
import racingcar.reader.CarNameReader;
import racingcar.reader.Reader;
import racingcar.reader.TurnValueReader;

public class RacingInfoReader {
	private final Reader<List<String>> carNameReader;
	private final Reader<Integer> turnValueReader;
	private final ConsoleDisplay consoleDisplay;

	public RacingInfoReader(ConsoleDisplay consoleDisplay) {
		this.carNameReader = new CarNameReader(consoleDisplay);
		this.turnValueReader = new TurnValueReader(consoleDisplay);
		this.consoleDisplay = consoleDisplay;
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

package racingcar.reader;

import java.util.List;

public class RacingInfo {
	private final List<String> carNames;
	private final int turnValue;

	public RacingInfo(int turnValue, List<String> carNames) {
		this.carNames = carNames;
		this.turnValue = turnValue;
	}

	public static RacingInfo of(Integer turnValue, List<String> carNames) {
		return new RacingInfo(turnValue, carNames);
	}

	public List<String> getCarNames() {
		return carNames;
	}

	public int getTurnValue() {
		return turnValue;
	}
}

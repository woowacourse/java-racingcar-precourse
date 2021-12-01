package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.reader.RacingInfo;
import static java.util.stream.Collectors.toList;

public class RacingGame {
	private final int maxTurnValue;
	private final List<Car> cars;
	private int currentTurnValue;

	public RacingGame(int maxTurnValue, List<Car> cars) {
		this.maxTurnValue = maxTurnValue;
		this.cars = cars;
		this.currentTurnValue = 0;
	}

	public static RacingGame of(RacingInfo info) {
		List<Car> cars = info.getCarNames().stream().map(Car::new).collect(toList());
		return new RacingGame(info.getTurnValue(), cars);
	}

	public boolean isFinished() {
		return currentTurnValue >= maxTurnValue;
	}

	public void proceed() {
		currentTurnValue++;
	}
}

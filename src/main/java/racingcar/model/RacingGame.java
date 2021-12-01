package racingcar.model;

import java.util.Arrays;
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

	public List<ProceedResult> proceed() {
		currentTurnValue++;
		moveCars();
		return convertToProceedResultList();
	}

	private void moveCars() {
		cars.forEach(Car::move);
	}

	private List<ProceedResult> convertToProceedResultList() {
		return cars.stream()
			.map(this::convertToProceedResult)
			.collect(toList());
	}

	private ProceedResult convertToProceedResult(Car c) {
		return ProceedResult.of(c.getName(), c.getPosition());
	}

	public List<String> getWinners() {
		List<Car> sortedCar = cars.stream()
			.sorted((a, b) -> Integer.compare(b.getPosition(), a.getPosition()))
			.collect(Collectors.toList());
		return Arrays.asList(sortedCar.get(0).getName());
	}
}

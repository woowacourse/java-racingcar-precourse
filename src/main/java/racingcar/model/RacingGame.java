package racingcar.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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
		return findWinners(findMostFarCar());
	}

	private Car findMostFarCar() {
		return cars.stream()
			.sorted(descendingOrderByPosition())
			.collect(Collectors.toList())
			.get(0);
	}

	private List<String> findWinners(Car mostFar) {
		return cars.stream()
			.filter(c -> isSamePosition(mostFar, c))
			.map(Car::getName)
			.collect(toList());
	}

	private boolean isSamePosition(Car mostFar, Car c) {
		return c.getPosition() == mostFar.getPosition();
	}


	private Comparator<Car> descendingOrderByPosition() {
		return (a, b) -> Integer.compare(b.getPosition(), a.getPosition());
	}
}

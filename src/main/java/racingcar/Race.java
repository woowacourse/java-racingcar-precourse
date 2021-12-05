package racingcar;

import java.util.ArrayList;

/**
 * <h1>입력받은 레이싱게임 정보를 토대로 레이싱 게임을 실행한다</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-05
 */

public class Race {

	private final ArrayList<Car> cars;

	private int turns;

	private int farthestPosition;

	public Race() {
		this(new ArrayList<>());
	}

	public Race(final ArrayList<Car> cars) {
		this.cars = cars;
		this.turns = 0;
		this.farthestPosition = 0;
	}

	private void printThisTurnResult() {
		cars.forEach(car -> {
			int carPosition = car.getPosition();
			final String carName = car.getName();

			farthestPosition = Math.max(farthestPosition, carPosition);

			RacingGameMessage.printCarPosition(carPosition, carName);
		});
		System.out.print("\n");
	}

	private void startNextTurn() {
		cars.forEach(Car::goForward);
		printThisTurnResult();
	}

	private void printWinnerList() {
		final String[] winners = cars.stream()
			.filter(car -> car.getPosition() == farthestPosition)
			.map(Car::getName)
			.toArray(String[]::new);
		final String winnerList = String.join(", ", winners);

		System.out.print(RacingGameMessage
			.getWinnerListMessage(winnerList));
	}

	public void startRace() {
		System.out.println(RacingGameMessage.GAME_RESULT);
		while (turns-- > 0) {
			startNextTurn();
		}
		printWinnerList();
	}

	public void addCar(final Car car) {
		this.cars.add(car);
	}

	public void removeCarList() {
		this.cars.clear();
	}

	public void setTurns(final int turns) {
		this.turns = turns;
	}
}

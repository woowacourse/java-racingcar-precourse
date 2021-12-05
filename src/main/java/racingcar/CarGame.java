package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarGame implements Runnable, CarGameRunner {
	private static final String WINNER = "최종 우승자 : ";
	private static final String WINNER_COMMA = ", ";

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;

	private final CarInitializer carInitializer;
	private final MovementGenerator movementGenerator;

	public CarGame(CarInitializer carInitializer, MovementGenerator movementGenerator) {
		this.carInitializer = carInitializer;
		this.movementGenerator = movementGenerator;
	}

	@Override
	public void run() {
		carInitializer.registerCars();
		startRace(CarRepository.getCars(), movementGenerator.createMoveCount().getCount());
		printWinner();
	}

	@Override
	public void startRace(List<Car> cars, int moveCount) {
		for (int round = 0; round < moveCount; round++) {
			race(cars);
		}
	}

	private void race(List<Car> cars) {
		cars.forEach(car -> {
			car.move(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			System.out.println(car.toString());
		});
		System.out.println();
	}

	@Override
	public void printWinner() {
		System.out.println(new StringBuilder()
			.append(WINNER)
			.append(String.join(WINNER_COMMA, CarRepository.getWinners()))
			.toString());
	}
}

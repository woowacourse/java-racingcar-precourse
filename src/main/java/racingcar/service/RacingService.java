package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingService {

	private static final CarRepository carRepository = new CarRepository();

	private static final int MIN_RANDOM_VALUE = 0;
	private static final int MAX_RANDOM_VALUE = 9;

	private static String FINAL_WINNER = "최종 우승자 : ";

	public void registerCars(String[] carNames) {
		Stream.of(carNames)
			.forEach(n -> carRepository.save(new Car(n)));
	}

	public void race() {
		carRepository.findAll()
			.stream()
			.forEach(car -> car.action(getRandomValue()));
	}

	private int getRandomValue() {
		return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
	}

	public void showRaceProgress() {
		List<Car> cars = carRepository.findAll();

		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			printProgressLine(car.getPosition());
		}
		System.out.println();
	}

	private void printProgressLine(int position) {
		for (int i = 1; i <= position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void showWinnersName() {
		pickWinners().stream()
			.forEach(w -> FINAL_WINNER += ", " + w.getName());

		System.out.println(FINAL_WINNER.replaceFirst(", ", ""));
	}

	private List<Car> pickWinners() {
		carRepository.sortByPosition();
		int winnerPosition = carRepository.findFirstCarPosition();

		return carRepository.findAll()
			.stream()
			.filter(c -> c.getPosition() == winnerPosition)
			.collect(Collectors.toList());
	}
}

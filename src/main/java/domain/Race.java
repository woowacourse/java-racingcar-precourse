package domain;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.utils.OutputUtils;

public class Race {
	private List<Car> carList;
	private Integer rounds;
	private List<Car> winnerList;
	private static final int MAX_MOVE = 10;

	public Race(List<String> carNameList, Integer rounds) {
		this.rounds = rounds;
		this.carList = makeCars(carNameList);
	}

	public void doGame() {
		for (int i = 0; i < rounds; i++) {
			runCars();
			showRoundResult();
		}
		winnerList = makeWinnerList();
	}

	private List<Car> makeCars(List<String> carNameList) {
		return carNameList.stream()
			.map(name -> new Car(name))
			.collect(Collectors.toList());
	}

	private void runCars() {
		Random random = new Random();
		for (Car car : carList
		) {
			car.run(random.nextInt(MAX_MOVE));
		}
	}

	private void showRoundResult() {
		for (Car car : carList
		) {
			OutputUtils.printCarProgress(car);
		}
		System.out.println();
	}

	private List<Car> makeWinnerList() {
		Integer winnerPosition = findMaxPosition();
		return carList.stream()
			.filter(car -> car.getPosition() == winnerPosition)
			.collect(Collectors.toList());
	}

	public List<String> getWinnerNameList() {
		if (winnerList == null) {
			winnerList = makeWinnerList();
		}
		return winnerList.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private Integer findMaxPosition() {
		Integer maxPosition = carList.stream()
			.max(Comparator.comparingInt(Car::getPosition))
			.get()
			.getPosition();
		return maxPosition;
	}
}

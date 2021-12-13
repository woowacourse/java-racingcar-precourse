package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.OutputView;

public class EveryCar {
	private final ArrayList<Car> cars = new ArrayList<>();

	public EveryCar(String[] carsName) {
		makeEveryCarInstance(carsName);
	}

	private void makeEveryCarInstance(String[] everyCarName) {
		Arrays.stream(everyCarName).forEach(eachCarName -> cars.add(new Car(eachCarName)));
	}

	public void moveEveryCarThisTiming() {
		cars.forEach(eachCar -> eachCar.move());
		OutputView.showResultThisTiming(cars);
	}

	public void showThisGameWinner() {
		Car winnerCar = findWinnerCar();
		List<String> winningCarsName = findWinnerCarsName(winnerCar.showMovingDistance());
		OutputView.showThisGameWinner(winningCarsName);
	}

	private List<String> findWinnerCarsName(int winnerCarsMovingDistance) {
		return cars.stream()
			.filter(eachCar -> winnerCarsMovingDistance == eachCar.showMovingDistance())
			.map(eachCar -> eachCar.getName())
			.collect(
				Collectors.toList());
	}

	private Car findWinnerCar() {
		Car winnerCar = cars.get(0);
		for (Car car : cars) {
			winnerCar = car.findMovedMore(winnerCar);
		}
		return winnerCar;
	}
}

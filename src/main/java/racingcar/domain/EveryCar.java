package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

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

	// public void showThisGameWinner() {
	// 	// cars를 순회해 가장 멀리 움직인 거리를 찾음.
	// 	// 해당 거리랑 똑같은 값들을 전부 찾음.
	// 	OutputView.showThisGameWinner(cars);
	// }
}

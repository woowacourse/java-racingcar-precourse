package racingcar;

import java.util.ArrayList;
import java.util.stream.Stream;

public class EveryCar {
	private final ArrayList<Car> cars;

	public EveryCar(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public void moveEveryCarThisTiming() {
		cars.stream().forEach(eachCar -> eachCar.move());
		showTheResultThisTiming();
	}

	private void showTheResultThisTiming() {
		cars.stream().forEach(eachCar -> System.out.println(String.format("%s : %s", eachCar, eachCar.showMovingMark())));
		System.out.println();
	}

	public void showThisGameWinner() {
		// cars.stream().forEach(eachCar -> eachCar.showMovingDistance());
		int winnerMovingDistance = cars.stream()
			.mapToInt(eachCar -> eachCar.showMovingDistance())
			.max()
			.orElseThrow(() -> new IllegalArgumentException("자동차의 최댓값이 존재하지 않습니다. 로직이 잘못되었습니다."));
		Stream<Car> winningCars = cars.stream().filter(eachCar -> eachCar.showMovingDistance() == winnerMovingDistance);
		winningCars.forEach(eachCar -> System.out.println(eachCar)); //TODO : 이녀석을 양식에 맞게 출력해주면 됨.
	}
}

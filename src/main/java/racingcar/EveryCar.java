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
		int winnerMovingDistance = cars.stream()
			.mapToInt(eachCar -> eachCar.showMovingDistance())
			.max()
			.orElseThrow(() -> new IllegalArgumentException("자동차의 최댓값이 존재하지 않습니다. 로직이 잘못되었습니다."));
		Car[] cars = this.cars.stream()
			.filter(eachCar -> eachCar.showMovingDistance() == winnerMovingDistance)
			.toArray(Car[]::new);
		String result = "최종 우승자 : ";
		for (Car car : cars) {
			result += car;
			if (car != cars[cars.length-1]) {
				result += ", ";
			}
		}
		System.out.println(result);
	}
}

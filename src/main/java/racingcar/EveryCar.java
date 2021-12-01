package racingcar;

import java.util.ArrayList;

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
}

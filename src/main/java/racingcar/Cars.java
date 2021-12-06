package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cars {
	private ArrayList<Car> cars = new ArrayList<>();

	public Cars(String[] carNames) {
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public void printAll() {
		for (Car car : cars) {
			car.printTrace();
		}
	}

	public void findWinner() {
		System.out.print("최종 우승자 : ");
		Collections.sort(cars, Comparator.reverseOrder());
		int tieNumber = calcTieNumber();
		for (int i = 0; i <= tieNumber; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			cars.get(i).printName();
		}
		System.out.println();
	}

	private int calcTieNumber() {
		int tieNumber = 0;
		Car firstPlaceCar = cars.get(0);
		for (int i = 1; i < cars.size(); i++) {
			if (firstPlaceCar.compareTo(cars.get(i)) != 0) {
				break;
			}
			tieNumber++;
		}
		return tieNumber;
	}
}

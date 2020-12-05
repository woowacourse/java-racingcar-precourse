package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Converter;

public class Racing {
	private final List<Car> cars;

	public Racing(String[] carNames) {
		cars = new ArrayList<>();

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void start(int roundNumber) {
		System.out.println("실행 결과");

		for (int round = 1; round <= roundNumber; round += 1) {
			moveCars();
			printRoundResult();
		}
	}

	private void moveCars() {
		for (Car car : cars) {
			car.movdOrStop();
		}
	}

	private void printRoundResult() {
		for (Car car : cars) {
			String carName = car.getName();
			String movement = Converter.convertToPosition(car.getPosition());

			System.out.println(carName + " : " + movement);
		}
		System.out.println();//공백추가
	}
}

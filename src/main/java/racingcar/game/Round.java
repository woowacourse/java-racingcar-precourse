package racingcar.game;

import java.util.List;

import racingcar.car.Car;
import racingcar.utils.Dice;

public class Round {
	List<Car> carList;

	Round(List<Car> carList) {
		this.carList = carList;
	}

	void run() {
		carList.forEach(car -> new CheckPoint(car).checkIn());
		System.out.println();
	}

	private class CheckPoint {
		final int CHECK_STANDARD = 4;
		Dice dice = new Dice();
		Car car;

		CheckPoint(Car car) {
			this.car = car;
		}

		void checkIn() {
			if (dice.roll() >= CHECK_STANDARD) {
				car.move();
			}
			printPosition();
		}

		void printPosition() {
			System.out.printf("%s : %s\n", car.getName(), builderPositionOutput());
		}

		String CAR_MOVE_SIGNAL = "-";

		StringBuilder builderPositionOutput() {
			StringBuilder output = new StringBuilder();
			for (int i = 0; i < car.getPosition(); i++) {
				output.append(CAR_MOVE_SIGNAL);
			}
			return output;
		}
	}
}

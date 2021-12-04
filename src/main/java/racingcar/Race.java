package racingcar;

import java.util.ArrayList;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
	private ArrayList<Car> carList;

	public ArrayList<Car> getCarList() {
		return this.carList;
	}

	Race(ArrayList<Car> carList, int repeatNum) {
		this.carList = carList;
		for (int i = 0; i < repeatNum; i++) {
			playRound();
		}
	}

	private void playRound() {
		for (Car c : carList) {
			c.moveIfNumGTE4(randNum());
		}
		printRaceProgress();
	}

	private int randNum() {
		return Randoms.pickNumberInRange(1, 9);
	}

	private void printRaceProgress() {
		for (Car car : carList) {
			printCarPosition(car);
		}
		System.out.println();
	}

	private void printCarPosition(Car car) {
		String currPosition = positionToStr(car.getPosition());
		String carName = car.getName();
		System.out.printf("%s : %s", carName, currPosition);
		System.out.println();
	}

	private String positionToStr(int position) {
		StringBuilder raceLine = new StringBuilder();
		IntStream.range(0, position).forEach(s -> raceLine.append("-"));
		return raceLine.toString();
	}
}

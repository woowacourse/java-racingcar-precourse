package racingcar;

import java.util.ArrayList;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
	private final ArrayList<Car> carList;

	Race(ArrayList<Car> carList) {
		this.carList = carList;
	}

	public ArrayList<Car> getResult(int repeatNum) {
		run(repeatNum);
		return this.carList;
	}

	private void run(int repeatNum) {
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
		String currPosition = getDashByNumber(car.getPosition());
		String carName = car.getName();
		System.out.printf("%s : %s", carName, currPosition);
		System.out.println();
	}

	private String getDashByNumber(int position) {
		StringBuilder currPosition = new StringBuilder();
		IntStream.range(0, position)
			.forEach(s -> currPosition.append("-"));
		return currPosition.toString();
	}
}
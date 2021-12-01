package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
	private List<Car> cars;
	private int round;

	public Race(List<Car> cars, int round) {
		this.cars = cars;
		this.round = round;
	}

	public void start() {
		System.out.println(Const.RACE_RESULT_MESSAGE);
		for(int i = 0; i < round; i++) {
			cars.forEach(Car::moveOrStop);
			printRoundResult();
		}
	}

	private void printRoundResult() {
		cars.forEach(Car::printPosition);
		System.out.println();
	}
}

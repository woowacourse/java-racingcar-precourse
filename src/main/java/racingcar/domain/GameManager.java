package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {

	private static final int MIN_PICK_NUMBER = 0;
	private static final int MAX_PICK_NUMBER = 9;
	private static final int CONDITION_TO_MOVE_FORWARD = 4;

	public int pickRandomNumber() {
		return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
	}

	public Car[] createCarInstance(List<String> carNameList) {
		Car[] carName = new Car[carNameList.size()];
		for (int i = 0; i < carNameList.size(); i++) {
			carName[i] = new Car(carNameList.get(i));
		}
		return carName;
	}

	public void makeCarMove(Car[] carName) {
		for (Car car : carName) {
			if (createRandomNumberForCarMovement()) {
				car.moveForward();
			}
		}
	}

	public boolean createRandomNumberForCarMovement() {
		int randomNumber = pickRandomNumber();
		return randomNumber >= CONDITION_TO_MOVE_FORWARD;
	}

	public ArrayList<Car> getWinner(Car[] carName) {
		ArrayList<Car> winnerList = new ArrayList<>();
		int maxValue = 0;
		for (Car car : carName) {
			if (car.getPosition() == maxValue) {
				winnerList.add(car);
				continue;
			}
			if (car.getPosition() > maxValue) {
				winnerList.clear();
				winnerList.add(car);
				maxValue = car.getPosition();
			}
		}
		return winnerList;
	}
}

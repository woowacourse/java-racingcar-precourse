package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {

	private static final int MIN_PICK_NUMBER = 0;
	private static final int MAX_PICK_NUMBER = 9;
	private static final int CONDITION_TO_MOVE_FORWARD = 4;

	public Car[] createCars(List<String> carNameList) {
		Car[] carName = new Car[carNameList.size()];

		for (int i = 0; i < carNameList.size(); i++) {
			carName[i] = new Car(carNameList.get(i));
		}
		return carName;
	}

	public void makeCarMoveForward(Car[] carName) {
		for (Car car : carName) {
			if (isSatisfiedRandomNumber()) {
				car.moveForward();
			}
		}
	}

	public boolean isSatisfiedRandomNumber() {
		return getRandomNumber() >= CONDITION_TO_MOVE_FORWARD;
	}

	public int getRandomNumber() {
		return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
	}

	public int findMaxPosition(Car[] carNameList) {
		int maxPosition = 0;
		for (Car name : carNameList) {
			if (maxPosition < name.getPosition()) {
				maxPosition = name.getPosition();
			}
		}
		return maxPosition;
	}

	public List<String> getWinnerList(Car[] carNameList) {
		int maxPosition = findMaxPosition(carNameList);
		ArrayList<String> winnerList = new ArrayList<>();

		for (Car name : carNameList) {
			if (name.getPosition() == maxPosition) {
				winnerList.add(name.getName());
			}
		}

		return winnerList;
	}
}

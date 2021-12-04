package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Constants;
import racingcar.domain.Car;

public class RaceManager {

	public void moveCars(List<Car> cars) {
		for(Car car : cars) {
			moveCar(car);
		}
	}

	private void moveCar(Car car) {
		int randomNumber = randomGenerate();
		if(checkMoveForward(randomNumber)) {
			car.increasePosition();
		}
	}

	private int randomGenerate() {
		return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUMBER, Constants.MAX_RANDOM_NUMBER);
	}

	private boolean checkMoveForward(int number) {
		return number >= Constants.MOVE_FORWARD_NUMBER;
	}

	public List<String> getWinners(List<Car> cars) {
		int maxPosition = getMaxPosition(cars);
		return checkWhoseWinners(cars, maxPosition);
	}

	private int getMaxPosition(List<Car> cars) {
		int maxPosition = 0;
		for(Car car : cars) {
			if(car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}

	private List<String> checkWhoseWinners(List<Car> cars, int maxPosition) {
		List<String> winners = new ArrayList<>();
		for(Car car : cars) {
			if(car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}

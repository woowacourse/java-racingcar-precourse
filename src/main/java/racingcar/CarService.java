package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class CarService {
	public static final int MIN_RANDOM = 0;
	public static final int MAX_RANDOM = 9;
	public static final int MOVE_CONDITION = 4;

	private OutputView outputView = new OutputView();

	public Car[] enrollCars(ArrayList<String> names) {
		Car[] cars = new Car[names.size()];
		for (int i = 0; i < names.size(); i++) {
			cars[i] = new Car(names.get(i));
		}
		return cars;
	}

	public void startEachRace(Car[] cars) {
		for (Car car : cars) {
			int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
			if (randomNumber >= MOVE_CONDITION) {
				car.moveForward();
			}
			outputView.displayPosition(car);
		}
		System.out.println();
	}

	public ArrayList<String> findWinners(Car[] cars) {
		int maxPosition = getMaxPosition(cars);
		ArrayList<String> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

	private int getMaxPosition(Car[] cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}
}

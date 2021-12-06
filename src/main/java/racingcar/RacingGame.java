package racingcar;

import java.util.ArrayList;
import java.util.List;

import com.sun.deploy.util.StringUtils;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

	public User user = new User();
	public List<Car> cars = new ArrayList<>();

	public void startGame() {
		makeCarList();
		Integer playRound = user.getGameNumber();
		runGame(playRound);
		printWinners();
	}

	public void makeCarList() {
		String[] carNames = user.getNames();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void runGame(int playRound) {
		for (int i = 0; i < playRound; i++) {
			moveCars();
			printCurrentResult();
		}
	}

	public void moveCars() {

		for (Car car : cars) {
			int randomNumber = generateRandomNumber();
			if (isMovable(randomNumber)) {
				car.moveOneStep();
			}
		}
	}

	public int generateRandomNumber() {
		return Randoms.pickNumberInRange(1, 9);
	}

	public boolean isMovable(int randomNumber) {
		if (randomNumber < 4) {
			return false;
		}
		return true;
	}

	public void printCurrentResult() {
		System.out.println();
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			printStatus(car.getPosition());
		}
	}

	public void printStatus(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public int findMaxPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			if (maxPosition < car.getPosition()) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;

	}

	public void printWinners() {
		List<String> winners = findWinners();
		System.out.println(StringUtils.join(winners, ", "));
	}

	public List<String> findWinners() {
		List<String> winners = new ArrayList<>();
		int maxPosition = findMaxPosition(cars);
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}
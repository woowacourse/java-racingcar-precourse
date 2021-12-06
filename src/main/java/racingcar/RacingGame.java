package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

	public User user = new User();
	public List<Car> cars = new ArrayList<>();

	public void startGame() {
		makeCarList();
		Integer playRound = user.getGameNumber();
		runGame(playRound);
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
}
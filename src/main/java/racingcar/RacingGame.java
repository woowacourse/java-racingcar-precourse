package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

	public User user;
	public List<Car> cars;

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

}

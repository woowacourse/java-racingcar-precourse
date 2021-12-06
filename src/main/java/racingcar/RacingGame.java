package racingcar;

import java.util.List;

public class RacingGame {

	public User user;
	public List<Car> cars;

	public void startGame() {
		makeCarList();
		Integer playRound = user.getGameNumber();
	}

	public void makeCarList() {
		String[] carNames = user.getNames();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}

	}

}

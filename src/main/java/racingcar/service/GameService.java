package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameService {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	private static final int FORWARD_CONDITION = 4;
	private Game game;

	public GameService(int trial, List<String> carNames) {
		this.game = new Game(trial, getCars(carNames));
	}

	private List<Car> getCars(List<String> carNames) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carNames.size(); i++) {
			carList.add(new Car(carNames.get(i)));
		}
		return carList;
	}

	public void play() {
		for (Car car : game.getCars()) {
			if (FORWARD_CONDITION <= getRandomNumber()) {
				car.moveForward(1);
			}
		}
		game.increaseTrialNum();
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}
}

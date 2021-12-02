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

	public GameService(int trial, List<Car> cars) {
		this.game = new Game(trial, cars);
	}

	public List<Car> play() {
		while (!game.checkReachTrialNumToTrial()) {
			moveForwardByRandomNumber();
			game.increaseTrialNum();
		}
		return getWinners();
	}

	private List<Car> getWinners() {
		int max = -1;
		List<Car> winners = new ArrayList<>();
		for (Car car : game.getCars()) {
			if (max == car.getPosition()) {
				winners.add(car);
			}
			if (max < car.getPosition()) {
				max = car.getPosition();
				winners = new ArrayList<>();
				winners.add(car);
			}
		}
		return winners;
	}

	private void moveForwardByRandomNumber() {
		for (Car car : game.getCars()) {
			if (FORWARD_CONDITION <= getRandomNumber()) {
				car.moveForward(1);
			}
		}
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}
}

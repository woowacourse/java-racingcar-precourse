package racingcar.domain;

import static racingcar.constant.GameConstants.Game.*;

import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private final List<Car> carList;
	private final GameLog gameLog;

	public Game(List<Car> carList) {
		this.carList = carList;
		this.gameLog = new GameLog();
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void runSingle() {
		carList.forEach(car -> car.moveByNumber(Randoms.pickNumberInRange(RANDOM_NUMBER_FROM_INCLUSIVE.getValue(),
			RANDOM_NUMBER_TO_INCLUSIVE.getValue())));
		gameLog.add(this);
	}

	public void runMultiple(int iterationNumber) {
		IntStream.range(0, iterationNumber).forEach(i -> runSingle());
	}

	@Override
	public String toString() {
		return gameLog.get(this);
	}
}

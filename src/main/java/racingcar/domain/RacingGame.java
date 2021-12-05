package racingcar.domain;

import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.type.RangeType;
import racingcar.view.OutputView;

public class RacingGame {

	private final Cars cars;
	private int gameRound;

	public RacingGame(Cars cars, int gameRound) {
		this.cars = cars;
		this.gameRound = gameRound;
		OutputView.printStartRace();
	}

	public boolean isFinish() {
		return gameRound == RangeType.ZERO.getValue();
	}

	public void race() {
		decreaseGameRound();
		for (Car car : cars.getCars()) {
			car.move(generateNumber());
			cars.updateWinnerPosition(car.getPosition());
		}
	}

	private void decreaseGameRound() {
		--gameRound;
	}

	private int generateNumber() {
		return Randoms.pickNumberInRange(RangeType.ZERO.getValue(),
			RangeType.MAX_RANDOM_NUMBER.getValue());
	}

	public String findWinner() {
		return cars.getCars().stream()
			.filter(car -> car.getPosition() == cars.getWinnerPosition())
			.map(car -> car.getName())
			.collect(Collectors.joining(", "));
	}
}

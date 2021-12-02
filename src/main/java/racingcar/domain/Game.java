package racingcar.domain;

import static racingcar.constant.GameConstants.Game.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private List<Car> carList;
	private List<Car> winnerList;
	private int farthestPosition;

	public Game(List<Car> carList) {
		this.carList = carList;
		this.winnerList = new ArrayList<>();
		this.farthestPosition = 0;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public List<Car> getWinnerList() {
		return winnerList;
	}

	public void runSingle() {
		carList.forEach(car -> {
			car.moveByNumber(Randoms.pickNumberInRange(RANDOM_NUMBER_FROM_INCLUSIVE.getValue(),
				RANDOM_NUMBER_TO_INCLUSIVE.getValue()));
			this.farthestPosition = Math.max(farthestPosition, car.getPosition());
		});
		this.winnerList = getWinnerCandidateList();
	}

	private List<Car> getWinnerCandidateList() {
		return carList.stream()
			.filter(car -> farthestPosition == car.getPosition())
			.collect(Collectors.toList());
	}
}

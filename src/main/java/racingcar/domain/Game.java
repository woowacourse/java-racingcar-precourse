package racingcar.domain;

import static racingcar.constant.GameConstants.Game.*;
import static racingcar.constant.GameConstants.GameStringConversion.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private List<Car> carList;
	private List<Car> winnerList;
	private StringBuilder gameResultStringBuilder;
	private int farthestPosition;

	public Game(List<Car> carList) {
		this.carList = carList;
		this.winnerList = new ArrayList<>();
		this.gameResultStringBuilder = new StringBuilder();
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
			gameResultStringBuilder.append(car).append(GAME_RESULT_POSTFIX.getString());
		});
		gameResultStringBuilder.append(GAME_RESULT_POSTFIX.getString());
		this.winnerList = getWinnerCandidateList();
	}

	private List<Car> getWinnerCandidateList() {
		return carList.stream()
			.filter(car -> farthestPosition == car.getPosition())
			.collect(Collectors.toList());
	}

	private String getGameResultString() {
		return gameResultStringBuilder.toString();
	}

	public void runMultiple(int iterationNumber) {
		IntStream.range(0, iterationNumber).forEach(i -> runSingle());
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(GAME_RESULT_HINT.getString());
		stringBuilder.append(getGameResultString());
		stringBuilder.append(GAME_WINNER_HINT.getString());
		winnerList.forEach(winner -> stringBuilder.append(winner.getName()).append(GAME_WINNER_DELIMITER.getString()));
		return stringBuilder.substring(0, stringBuilder.length() - GAME_WINNER_DELIMITER.getString().length());
	}
}

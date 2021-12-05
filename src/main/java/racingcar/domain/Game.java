package racingcar.domain;

import static racingcar.constant.GameConstants.Game.*;
import static racingcar.constant.GameConstants.GameStringConversion.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private final List<Car> carList;
	private List<Car> winnerCandidateList;
	private final StringBuilder gameResultStringBuilder;
	private int farthestPosition;

	public Game(List<Car> carList) {
		this.carList = carList;
		this.winnerCandidateList = new ArrayList<>();
		this.gameResultStringBuilder = new StringBuilder();
		this.farthestPosition = 0;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public List<Car> getWinnerCandidateList() {
		return winnerCandidateList;
	}

	public void runSingle() {
		carList.forEach(car -> {
			car.moveByNumber(Randoms.pickNumberInRange(RANDOM_NUMBER_FROM_INCLUSIVE.getValue(),
				RANDOM_NUMBER_TO_INCLUSIVE.getValue()));
			this.farthestPosition = Math.max(farthestPosition, car.getPosition());
			gameResultStringBuilder.append(car).append(GAME_RESULT_POSTFIX.getString());
		});
		gameResultStringBuilder.append(GAME_RESULT_POSTFIX.getString());
		saveWinnerCandidateList();
	}

	private void saveWinnerCandidateList() {
		this.winnerCandidateList = carList.stream()
			.filter(car -> farthestPosition == car.getPosition())
			.collect(Collectors.toList());
	}

	private String getGameResultString() {
		return gameResultStringBuilder.toString();
	}

	private String removeLastDelimiterFromWinner(StringBuilder resultString) {
		return resultString.substring(0, resultString.length() - GAME_WINNER_DELIMITER.getString().length());
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
		winnerCandidateList.forEach(
			winner -> stringBuilder.append(winner.getName()).append(GAME_WINNER_DELIMITER.getString()));
		return removeLastDelimiterFromWinner(stringBuilder);
	}
}

package racingcar.domain;

import static racingcar.constant.GameConstants.GameStringConversion.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GameLog {
	private final StringBuilder log;

	public GameLog() {
		this.log = new StringBuilder(GAME_RESULT_HINT.getString());
	}

	public void add(Game game) {
		game.getCarList().forEach(car -> log.append(car).append(GAME_RESULT_POSTFIX.getString()));
		log.append(GAME_RESULT_POSTFIX.getString());

	}

	public String get(Game game) {
		StringBuilder resultString = new StringBuilder(log);
		resultString.append(GAME_WINNER_HINT.getString());
		Car farthestCar = Collections.max(game.getCarList(), Comparator.comparingInt(Car::getPosition));
		game.getCarList()
			.stream()
			.filter(car -> car.getPosition() == farthestCar.getPosition())
			.collect(Collectors.toList())
			.forEach(winner -> resultString.append(winner.getName()).append(GAME_WINNER_DELIMITER.getString()));
		return removeLastDelimiterFromWinner(resultString);
	}

	private String removeLastDelimiterFromWinner(StringBuilder resultString) {
		return resultString.substring(0, resultString.length() - GAME_WINNER_DELIMITER.getString().length());
	}
}

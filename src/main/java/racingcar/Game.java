package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
	private Cars cars;
	private int gameRound;

	public void play() {
		getCarsWithErrorHandling();
		getGameRoundWithErrorHandling();
		Referee referee = new Referee();

		OutputView.showGameResultMessage();
		for (int i = 0; i < gameRound; i++) {
			cars.playRound();
			OutputView.showGameRoundResult(cars.showCarsPosition());
		}
		Collections.sort(cars.getCars(), new Referee());
		OutputView.showWinner(referee.selectWinners(cars));
	}

	public List<String> parsingCarNames(String noParsingCarNames) {
		String[] parsingCarNames = noParsingCarNames.split(Constant.CAR_NAME_PARSER);
		List<String> carNames = Arrays.asList(parsingCarNames);
		return carNames;
	}

	public List<Car> constructCar(List<String> stringCarNames) {
		List<Car> carNames = new ArrayList<>();
		for (String stringCarName : stringCarNames) {
			Car car = new Car(stringCarName.trim());
			carNames.add(car);
		}
		return carNames;
	}

	public int castingGameRound(String stringGameRound) {
		int gameRound = Integer.parseInt(stringGameRound);
		Validator.validateGameRound(gameRound);
		return gameRound;
	}

	private void getCarsWithErrorHandling() {
		try {
			cars = new Cars(constructCar(parsingCarNames(InputView.inputCarNames())));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			getCarsWithErrorHandling();
		}
	}

	private void getGameRoundWithErrorHandling() {
		try {
			gameRound = castingGameRound(InputView.inputGameRound());
		} catch (NumberFormatException exception) {
			System.out.println(Constant.GAME_ROUND_TYPE_ERROR_MESSAGE);
			getGameRoundWithErrorHandling();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			getGameRoundWithErrorHandling();
		}
	}
}
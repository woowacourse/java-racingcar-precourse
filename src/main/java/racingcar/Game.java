package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
	public void play() {
		Cars cars = new Cars(constructCar(parsingCarNames(InputView.inputCarNames())));
		Referee referee = new Referee(cars);
		int gameRound = castingGameRound(InputView.inputGameRound());
		OutputView.showGameResultMessage();
		for (int i = 0; i < gameRound; i++) {
			cars.playRound();
			OutputView.showGameRoundResult(cars.showCarsPosition());
		}
		Collections.sort(cars.getCars(), new Referee(cars));
		OutputView.showWinner(referee.selectWinners());
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
		validateGameRound(gameRound);
		return gameRound;
	}

	public void validateGameRound(int gameRound) {
		if (gameRound < Constant.MINIMUM_GAME_ROUND) {
			throw new IllegalArgumentException();
		}
	}
}
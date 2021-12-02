package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	public void play() {
		constructCar(parsingCarNames(InputView.inputCarNames()));
	}

	public List<String> parsingCarNames(String noParsingCarNames) {
		String[] parsingCarNames = noParsingCarNames.split(Constant.CAR_NAME_PARSER);
		List<String> carNames = Arrays.asList(parsingCarNames);
		return carNames;
	}

	public List<Car> constructCar(List<String> stringCarNames){
		List<Car> carNames = new ArrayList<>();
		for (String stringCarName : stringCarNames) {
			Car car = new Car(stringCarName.trim());
			carNames.add(car);
		}
		return carNames;
	}

	public int castingGameRound(String stringGameRound){
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

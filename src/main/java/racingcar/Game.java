package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	public void play() {
		List<Car> cars = constructCar(parsingCarNames(InputView.inputCarNames()));
		int gameRound = castingGameRound(InputView.inputGameRound());
		OutputView.showGameResultMessage();
		for (int i = 0; i < gameRound; i++) {
			playRound(cars);
			OutputView.showGameRoundResult(showCarsPosition(cars));
		}
		Referee referee = new Referee();
		Collections.sort(cars, new Referee());
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
		validateGameRound(gameRound);
		return gameRound;
	}

	public void validateGameRound(int gameRound) {
		if (gameRound < Constant.MINIMUM_GAME_ROUND) {
			throw new IllegalArgumentException();
		}
	}

	public String makeCarProgressSign(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append(Constant.CAR_PROGRESS_SIGN);
		}
		return stringBuilder.toString();
	}

	public LinkedHashMap<Car, String> showCarsPosition(List<Car> cars) {
		LinkedHashMap<Car, String> roundResult = new LinkedHashMap<>();
		for (Car car : cars) {
			String carPosition = makeCarProgressSign(car.getPosition());
			roundResult.put(car, carPosition);
		}
		return roundResult;
	}

	public void playRound(List<Car> cars) {
		for (Car car : cars) {
			int random = Randoms.pickNumberInRange(Constant.MINIMUM_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
			car.proceed(random);
		}
	}
}
package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

	InputHandler inputHandler;
	Judgement judgement;

	public GameEngine() {
		inputHandler = new InputHandler();
		judgement = new Judgement();
	}

	public void start() {
		System.out.println(GameData.CARNAME_INPUT_MESSAGE);
		List<Car> carList = generateCars(readCarNames());
		System.out.println(GameData.TRY_INPUT_MESSAGE);
		int count = readCount();
		System.out.println(GameData.RESULT_MESSAGE);
		while(!judgement.checkGameEnd(count--)) {
			moveCars(carList);
			System.out.println(getGameStatus(carList));
		}
		judgement.judgeRanking(carList);
		List<Car> winnerList = judgement.judgeWinner(carList);
		System.out.println(GameData.WINNER_MESSAGE + generateWinnerInformation(winnerList));
	}

	public List<String> readCarNames() {
		while (true) {
			try {
				return inputHandler.readRacingCarNames();
			} catch (IllegalArgumentException iae) {
				System.err.println(String.format(GameData.CARNAME_LIMIT_ERROR_MESSAGE, GameData.CARNAME_LIMIT));
			}
		}
	}

	public List<Car> generateCars(List<String> carNames) {
		List<Car> results = new ArrayList<Car>();
		for (String carName : carNames) {
			results.add(new Car(carName));
		}
		return results;
	}

	public int readCount() {
		while (true) {
			try {
				return inputHandler.readCount();
			} catch (IllegalArgumentException iae) {
				System.err.println(GameData.INPUT_ERROR_MESSAGE);
			}
		}
	}

	public void moveCars(List<Car> carList) {
		for (Car car : carList) {
			car.moveForward();
		}
	}

	public String getGameStatus(List<Car> carList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : carList) {
			stringBuilder.append(generateCarInformation(car));
		}
		return stringBuilder.toString();
	}

	public String generateWinnerInformation(List<Car> winnerList) {
		StringBuilder stringBuilder = new StringBuilder();
		for(Car car:winnerList) {
			if(stringBuilder.length() != 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(car.getName());
		}
		return stringBuilder.toString();
	}

	private String generateCarInformation(Car car) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			stringBuilder.append("-");
		}
		return String.format("%s : %s\n", car.getName(), stringBuilder.toString());
	}
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

	InputHandler inputHandler;
	OutputHandler outputHandler;
	Judgement judgement;

	public GameEngine() {
		inputHandler = new InputHandler();
		outputHandler = new OutputHandler();
		judgement = new Judgement();
	}

	public void start() {
		List<Car> carList = generateCars(inputHandler.getValidCarNames());
		int count = inputHandler.getValidTurnCount();
		System.out.println(GameData.RESULT_MESSAGE);
		while (!judgement.checkGameEnd(count--)) {
			moveCars(carList);
			outputHandler.printTurnStatus(carList);
		}
		judgement.judgeRanking(carList);
		List<Car> winnerList = judgement.judgeWinner(carList);
		System.out.println(GameData.WINNER_MESSAGE + generateWinnerInformation(winnerList));
	}

	public List<Car> generateCars(List<String> carNames) {
		List<Car> results = new ArrayList<Car>();
		for (String carName : carNames) {
			results.add(new Car(carName));
		}
		return results;
	}

	public void moveCars(List<Car> carList) {
		for (Car car : carList) {
			car.moveForward();
		}
	}

	public String generateWinnerInformation(List<Car> winnerList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : winnerList) {
			if (stringBuilder.length() != 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(car.getName());
		}
		return stringBuilder.toString();
	}
}

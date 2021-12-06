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
		outputHandler.printBlankLine();
		outputHandler.printMessage(GameData.RESULT_MESSAGE);
		while (!judgement.checkGameEnd(count--)) {
			moveCars(carList);
			outputHandler.printTurnStatus(carList);
		}
		judgement.judgeRanking(carList);
		List<Car> winnerList = judgement.judgeWinner(carList);
		outputHandler.printWinner(winnerList);
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
}

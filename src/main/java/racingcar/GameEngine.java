package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

	InputHandler inputHandler;
	OutputHandler outputHandler;
	Judgement judgement;

	public GameEngine(InputHandler inputHandler, OutputHandler outputHandler, Judgement judgement) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.judgement = judgement;
	}

	public void start() {
		List<Car> carList = generateCars(inputHandler.getValidCarNames());
		int count = inputHandler.getValidTurnCount();
		proceedGame(carList, count);
		List<Car> winnerList = judgement.judgeWinner(carList);
		outputHandler.printWinner(winnerList);
	}

	public void proceedGame(List<Car> carList, int count) {
		outputHandler.printBlankLine();
		outputHandler.printMessage(GameData.RESULT_MESSAGE);
		for (int i = 0; i < count; i++) {
			tryMoveCars(carList);
			outputHandler.printTurnStatus(carList);
		}
	}

	public List<Car> generateCars(List<String> carNames) {
		List<Car> results = new ArrayList<Car>();
		for (String carName : carNames) {
			results.add(new Car(carName));
		}
		return results;
	}

	public void tryMoveCars(List<Car> carList) {
		for (Car car : carList) {
			car.moveForward();
		}
	}
}

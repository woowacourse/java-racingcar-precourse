package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.data.GameData;
import racingcar.domain.Car;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class GameEngine {

	private InputHandler inputHandler;
	private OutputHandler outputHandler;
	private Judgement judgement;

	public GameEngine(InputHandler inputHandler, OutputHandler outputHandler, Judgement judgement) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.judgement = judgement;
	}

	public void start() {
		List<Car> carList = generateCars(inputHandler.getValidCarNames());
		int turnCount = inputHandler.getValidTurnCount();
		proceedGame(carList, turnCount);
		List<Car> winnerList = judgement.judgeWinner(carList);
		outputHandler.printWinner(winnerList);
	}

	private void proceedGame(List<Car> carList, int turnCount) {
		outputHandler.printBlankLine();
		outputHandler.printMessage(GameData.RESULT_MESSAGE);
		for (int i = 0; i < turnCount; i++) {
			tryMoveCars(carList);
			outputHandler.printTurnStatus(carList);
		}
	}

	private List<Car> generateCars(List<String> carNames) {
		List<Car> results = new ArrayList<Car>();
		for (String carName : carNames) {
			results.add(new Car(carName));
		}
		return results;
	}

	private void tryMoveCars(List<Car> carList) {
		for (Car car : carList) {
			car.moveForward();
		}
	}
}

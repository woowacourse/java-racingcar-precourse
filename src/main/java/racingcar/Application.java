package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
	public static void main(String[] args) {
		runGame();
	}

	public static void runGame() {
		List<Car> userInputNameList = loopInputNameListUntilValid();
		Game game = new Game(userInputNameList);
		game.runMultiple(loopInputIterationNumberUntilValid());

		OutputView.printGameResult(game);
	}

	private static List<Car> loopInputNameListUntilValid() {
		while (true) {
			try {
				return InputView.inputNameList();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static int loopInputIterationNumberUntilValid() {
		while (true) {
			try {
				return InputView.inputIterationNumber();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

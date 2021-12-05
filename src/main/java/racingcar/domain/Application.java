package racingcar.domain;

import static racingcar.view.OutputView.*;

public class Application {
	public static void main(String[] args) {
		Game newGame = new Game();
		newGame.runGame();
		printWinners(newGame.carList);
	}
}

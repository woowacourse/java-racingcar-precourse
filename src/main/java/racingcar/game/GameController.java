package racingcar.game;

import racingcar.car.CarNames;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class GameController {
	public void run() {
		Game game = new Game();
		InputView.startMessage();
		inputCarName();
	}

	public void inputCarName() {
		try {
			CarNames carNames = new CarNames();
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			inputCarName();
		}
	}
}

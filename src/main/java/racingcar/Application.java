package racingcar;

import java.util.List;

import racingcar.game.RacingGame;
import racingcar.utils.CarNameInput;
import racingcar.utils.GameTimesInput;
import racingcar.utils.validator.CarNameValidator;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		RacingGame racingGame = new RacingGame();
		racingGame.init();
		racingGame.gameStart();
		racingGame.awards();
	}
}

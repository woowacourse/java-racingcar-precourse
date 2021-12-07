package racingcar;

import racingcar.view.Game;
import racingcar.view.classes.GameMachine;

public class Application {
	public static void main(String[] args) {
		Game racingCarGame = new GameMachine();
		racingCarGame.start();
	}
}

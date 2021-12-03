package racingcar.racinggame;

import racingcar.user.Input;

public class Game {
	private final Input input;

	public Game() {
		input = new Input();
	}

	public void start() {
		String[] carNames = input.inputCarNames();
		String round = input.inputRound();
	}
}

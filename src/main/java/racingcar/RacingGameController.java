package racingcar;

class RacingGameController {
	private RacingGameView racingGameView;

	public RacingGameController() {
		racingGameView = RacingGameView.getRacingGameView();
	}

	public void startGame() {
		racingGameView.getCarNames();
	}
}

package racingcar.game;

import racingcar.controller.GameController;
import racingcar.domain.car.CarSet;
import racingcar.domain.round.RacingRound;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingGame implements Game {

	private final InputView inputView;
	private final OutputView outputView;
	private final GameController gameController;

	public RacingGame(InputView inputView, OutputView outputView, GameController gameController) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.gameController = gameController;
	}

	@Override
	public void play() {
		CarSet carSet = inputView.inputCarSet();
		RacingRound round = inputView.inputRacingRound();
		outputView.showInit();
		while (gameController.play(round, carSet)) {
			outputView.showProcess(carSet);
		}
		outputView.showResult(carSet);
	}
}

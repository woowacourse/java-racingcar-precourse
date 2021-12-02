package racingcar.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.view.InputView;

public class Controller {
	private GameService gameService;
	private Parser parser = new Parser();

	public void run() {
		InputView.requestCarNamesMessage();
		List<String> carNames = parser.parseCarNames(Console.readLine());
		InputView.requestNumberOfTrialMessage();
		int trial = parser.parseNumberOfTrial(Console.readLine());
		gameService = new GameService(trial, carNames);
	}
}

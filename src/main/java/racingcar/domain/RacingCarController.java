package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

import racingcar.model.RacingCars;
import racingcar.view.OutputView;

public class RacingCarController {
	public void start(String[] names, int roundCount) {
		RacingCars racingCars = new RacingCars(new ArrayList<>(Arrays.asList(names)));

		System.out.println("\n실행 결과");
		for (int i = 0; i < roundCount; i++) {
			OutputView.printRoundResult(racingCars.getRoundResult());
		}
		OutputView.printWinner(racingCars.getWinners());
	}
}

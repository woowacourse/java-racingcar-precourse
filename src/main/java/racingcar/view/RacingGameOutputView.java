package racingcar.view;

import static racingcar.constants.HostMessages.*;

import java.util.List;

public class RacingGameOutputView {
	private static final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();

	private RacingGameOutputView() {
	}

	public static RacingGameOutputView getRacingGameOutputView() {
		return racingGameOutputView;
	}

	public void printMovementStart() {
		System.out.println(MOVEMENT_RESULT_START_SENTENCE);
	}

	public void printMovement(List<String> visualizedPositions, List<String> carNames) {
		for (int i = 0; i < carNames.size(); i++) {
			System.out.println(carNames.get(i) + " : " + visualizedPositions.get(i));
		}
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		System.out.println(FINAL_RESULT_MESSAGE + String.join(", ", winners));
	}
}

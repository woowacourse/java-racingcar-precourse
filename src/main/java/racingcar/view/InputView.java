package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.view.OutputView.*;

import racingcar.domain.CarNames;

public class InputView {
	public static String[] readCarNames() {
		printReadCarNamesMessage();
		while (true) {
			try {
				String[] names = readLine().split(",");
				return (new CarNames(names)).get();
			} catch (IllegalArgumentException e) {
				printErrorMessage(e.getMessage());
			}
		}
	}

	public static int readRacingRound() {
		printReadRacingRoundMessage();
		String racingRound = readLine();
		return Integer.parseInt(racingRound);
	}
}

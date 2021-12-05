package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.view.OutputView.*;

import racingcar.domain.CarNames;
import racingcar.domain.RacingRound;

public class InputView {
	public static String[] readCarNames() {
		printReadCarNamesMessage();
		while (true) {
			try {
				String[] names = readLine().split(",");
				return (new CarNames(names)).get();
			} catch (IllegalArgumentException e) {
				printErrorMessage(e);
			}
		}
	}

	public static int readRacingRound() {
		printReadRacingRoundMessage();
		while (true) {
			try {
				String racingRound = readLine();
				return (new RacingRound(racingRound)).get();
			} catch (IllegalArgumentException e) {
				printErrorMessage(e);
			}
		}
	}
}

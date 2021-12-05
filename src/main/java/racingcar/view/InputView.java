package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.view.OutputView.*;

public class InputView {
	public static String[] readCarNames() {
		printReadCarNamesMessage();
		String[] names = readLine().split(",");
		return names;
	}
}

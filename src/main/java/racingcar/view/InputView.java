package racingcar.view;

import static racingcar.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String enterEveryCarName() {
		System.out.println(INPUT_EVERY_CAR_NAME_MESSAGE);
		return Console.readLine();
	}

	public static String enterTryCnt() {
		System.out.println(INPUT_TRY_CAR_MOVING_CNT);
		return Console.readLine();
	}
}

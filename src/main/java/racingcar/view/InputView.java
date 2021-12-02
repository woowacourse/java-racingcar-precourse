package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constant;

public class InputView {
	public static String inputCar() {
		System.out.println(Constant.INPUT_CAR_MESSAGE);
		return Console.readLine();
	}
}

package racingcar.view;

import racingcar.utils.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String[] getCarNames() {
		System.out.println(Constant.INPUT_CAR_NAME);
		return Console.readLine().split(Constant.DELIMITER_CAR_NAME);
	}

	public static String getTryNum() {
		System.out.println(Constant.INPUT_TRY_NUM);
		return Console.readLine();
	}

}

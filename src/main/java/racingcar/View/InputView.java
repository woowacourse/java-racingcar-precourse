package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant;

public class InputView {
    public static String inputName() {
        System.out.println(Constant.PLEASE_INPUT_NAMES);
        return Console.readLine();
    }

    public static String inputAttempt() {
        System.out.println(Constant.PLEASE_INPUT_ATTEMPT);
        return Console.readLine();
    }
}

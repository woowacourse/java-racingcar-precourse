package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.SystemMessage;

public class InputView {
    public static String printGetCarsNameMessage() {
        System.out.println(SystemMessage.GET_CAR_NAME_MESSAGE.print());
        return Console.readLine();
    }

    public static String printGetTryNumberMessage() {
        System.out.println(SystemMessage.GET_TRY_NUMBER_MESSAGE.print());
        return Console.readLine();
    }
}

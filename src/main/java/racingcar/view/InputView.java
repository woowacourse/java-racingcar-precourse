package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.view.ViewConstants.*;

public class InputView {

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MSG);
        return Console.readLine();
    }

    public static String inputRaceTimes() {
        System.out.println(INPUT_PLAY_TIMES_MSG);
        return Console.readLine();
    }
}

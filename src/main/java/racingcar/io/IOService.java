package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.Validation;

public class IOService {
    public static String readCarNames() {
        return Validation.inputCarNames(Console.readLine());
    }

    public static int readRoundCount() {
        return Validation.inputRoundCount(Console.readLine());
    }
}

package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.util.VerificationUtil.checkCarName;
import static racingcar.util.VerificationUtil.validatePositiveNumber;

public class UserInputUtil {

    private UserInputUtil() {
    }

    public static int getIntNum() {
        String input = Console.readLine();

        validatePositiveNumber(input);

        int number = Integer.parseInt(input);

        return number;
    }

    public static String[] getCarNames() {
        String input = Console.readLine();

        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            checkCarName(carNames[i]);
        }

        return carNames;
    }
}

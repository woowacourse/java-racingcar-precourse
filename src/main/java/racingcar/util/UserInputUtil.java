package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class UserInputUtil {

    private UserInputUtil() {
    }

    public static int getIntNum() {
        String input = Console.readLine();

        int number = toInteger(input);

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

    private static void checkCarName(String input) {
        if(input.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    private static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}

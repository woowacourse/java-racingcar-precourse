package racingcar.util;

public class UserInputUtil {

    private UserInputUtil() {
    }

    private static void checkCarName(String input) {
        if(input.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야 합니다.");
        }
    }
}

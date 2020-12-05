package utils;

public class ValidatorUtils {
    private static final int MAX_CAR_NAME = 5;

    private ValidatorUtils(){

    }

    public static void checkUnderFiveLetters(String[] carNames) {
        for (String carName:  carNames) {
            if (carName.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하이어야 한다.");
            }
        }
    }
}

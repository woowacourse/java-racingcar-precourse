package utils;

public class GameUtils {
    private static final String NAME_OVER_MESSAGE = "[ERROR] 차 이름은 5글자 이하여야 한다.";

    private GameUtils() {
    }

    public static void isCarNameRight(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(NAME_OVER_MESSAGE);
        }
    }

    public Boolean isNumOfRunsRight() {
        return true;
    }
}

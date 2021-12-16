package racingcar;

public class Validators {

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}

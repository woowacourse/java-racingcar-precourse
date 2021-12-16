package racingcar;

public class Validators {
    private static final String CAR_LENGTH_ERROR = "차의 이름은 5자 이내이어야 한다.";
    private static final String TRY_COUNT_NUMBER_ERROR = "시도 회수는 숫자여야 한다.";

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_LENGTH_ERROR);
        }
    }

    public static void validateTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_ERROR);
        }
    }


}

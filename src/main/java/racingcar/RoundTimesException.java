package racingcar;

public class RoundTimesException {
    public static void validateRoundTimes(String times) {
        isNumber(times);
        isPositiveInteger(times);
    }

    public static void isNumber(String times) {
        if (!times.matches("-?\\d+")) {
            throw new IllegalArgumentException(Constant.ERROR_NOT_NUMBER_TIMES);
        }
    }

    public static void isPositiveInteger(String times) {
        if (Integer.parseInt(times) <= 0) {
            throw new IllegalArgumentException(Constant.ERROR_POSITIVE_INTEGER);
        }
    }
}

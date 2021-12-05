package racingcar;

public class RoundTimesException {
    public static void validateRoundTimes(String times) {
        isNumber(times);
        isPositiveInteger(times);
    }

    public static void isNumber(String times) {
        if (!times.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수여야 합니다.");
        }
    }

    public static void isPositiveInteger(String times) {
        if (Integer.parseInt(times) <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양의 정수여야 합니다.");
        }
    }
}

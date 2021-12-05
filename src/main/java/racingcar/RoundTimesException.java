package racingcar;

public class RoundTimesException {

    public static void isNumber(String times) {
        if (!times.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수여야 합니다.");
        }
    }
}

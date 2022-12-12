package racingcar.util;

import java.util.Arrays;

public class Validator {

    public static final String DELIMITER = ",";

    public static void validateCarName(String carNames) {
        // 공백을 입력했을 경우
        validateBlank(carNames);
        // 자동차 길이는 5 이하
        validateCarNameLength(carNames);
        // ,로 분리했을 때, 자동차 길이가 공백이거나 비어 있을 경우
        validateEmptyCarName(carNames);
        // 중복된 값이 있을 경우 예외발생
        validateDuplicateCarName(carNames);
//        Arrays.stream(carNames.split(DELIMITER)).filter(car -> car.length() < )
    }

    private static void validateDuplicateCarName(String carNames) {
        if (getCarCount(carNames) != getDistinctCarCount(carNames)) {
            throw new IllegalArgumentException("[ERROR] 중복된 값을 입력하셨습니다. 다시 입력해 주세요");
        }
    }

    private static long getDistinctCarCount(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .distinct()
                .count();
    }

    private static long getCarCount(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .count();
    }

    private static void validateEmptyCarName(String carNames) {
        if (isBlankCarNameExist(carNames) ){
            throw new IllegalArgumentException("[ERROR] 길이가 5이하의 자동차 이름을 다시 입력해 주세요");
        }
    }

    private static boolean isBlankCarNameExist(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .anyMatch(car -> car.trim().length() == 0);
    }

    private static void validateCarNameLength(String carNames) {
        if (isCarNameMoreThanFiveLetters(carNames)){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5이하여야 합니다");
        }
    }

    private static boolean isCarNameMoreThanFiveLetters(String carNames) {
        long carNameOverFive = Arrays.stream(carNames.split(DELIMITER)).filter(car -> car.length() > 5).count();
        return carNameOverFive > 0;
    }

    private static void validateBlank(String carNames) {
        if (carNames.split(",").length == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 다시 입력해 주세요");
        }
    }
    public static void validateNumberValue(long longValue) {
        if (longValue >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] INT 범위 안의 숫자를 입력해 주세요");
        }
    }

    public static void validateGameCount(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 값을 입력해 주세요");
        }
    }
}

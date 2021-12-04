package racingcar;


public class InputValidator {

    public static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 1글자 이상의 이름을 입력하세요.");
        }
        for (String carName: carNames) {
            if (carName.length() >= 6) {
                throw new IllegalArgumentException("[ERROR] 5글자 이하의 이름을 입력하세요.");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 1글자 이상의 이름을 입력하세요.");
            }
        }
    }

    public static void validateNumberOfTry(String numberOfTryStr) {
        for (int i = 0; i < numberOfTryStr.length(); i++) {
            if (numberOfTryStr.charAt(i) - '0' <= 0) {
                throw new IllegalArgumentException("[ERROR] 1 이상의 정수를 입력하세요.");
            }
        }
    }
}

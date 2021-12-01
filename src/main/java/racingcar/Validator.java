package racingcar;

public class Validator {

    private static final String ERROR = "[ERROR] ";

    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
            validateCarNameFormat(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() >= 6) {
            throw new IllegalArgumentException(ERROR + "자동차명은 최대 5글자여야 한다.");
        }
    }

    private static void validateCarNameFormat(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ERROR + "자동차명에 공백이 포함되어서는 안 된다.");
        }
    }
}

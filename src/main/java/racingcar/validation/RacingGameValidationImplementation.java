package racingcar.validation;

import java.util.regex.Pattern;

public class RacingGameValidationImplementation implements InputValidation {

    private static final int LIMITED_LENGTH = 5;
    private static final int ZERO_LENGTH = 0;
    private static final int NOT_FOUND_BLANK = -1;
    private static final String INPUT_DELIMITER = ",";
    private static final Pattern hangulAndCharacterAndNumericPattern = Pattern.compile("^[a-zA-Z0-9ㄱ-ㅎ가-힣]*$");

    private RacingGameValidationImplementation() {
    }

    private static class LazyHolder {

        public static final RacingGameValidationImplementation INSTANCE = new RacingGameValidationImplementation();
    }

    public static RacingGameValidationImplementation getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void validCarNames(String inputTheCarNames) {
        if (isSameEndingCharacterInputDelimiter(inputTheCarNames)) {
            throw new IllegalArgumentException();
        }
        String[] carNames = StringToStringArray(inputTheCarNames);
        for (String carName : carNames) {
            if (isContainsBlanks(carName) || !isLessThan5Length(carName) || isNull(carName)
                || isContainsSpecialCharacter(carName)) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void validNumberOfAttempts(String numberOfAttempts) {

        if (isNull(numberOfAttempts)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < numberOfAttempts.length(); i++) {
            if (!Character.isDigit(numberOfAttempts.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isSameEndingCharacterInputDelimiter(String inputCarNames) {
        return inputCarNames.charAt(inputCarNames.length() - 1) == INPUT_DELIMITER.charAt(0);
    }

    private boolean isLessThan5Length(String carName) {
        return carName.length() <= LIMITED_LENGTH;
    }

    private boolean isContainsBlanks(String carName) {
        return carName.indexOf(' ') != NOT_FOUND_BLANK;
    }

    private boolean isContainsSpecialCharacter(String carName) {
        return !hangulAndCharacterAndNumericPattern.matcher(carName).matches();
    }

    private boolean isNull(String carName) {
        return carName.length() == ZERO_LENGTH;
    }

    private String[] StringToStringArray(String inputTheCarNames) {
        return inputTheCarNames.split(INPUT_DELIMITER);
    }
}

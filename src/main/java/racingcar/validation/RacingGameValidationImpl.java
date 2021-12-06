package racingcar.validation;

import java.util.regex.Pattern;

public class RacingGameValidationImpl implements InputValidation {

    private static final int LIMITED_LENGTH = 5;
    private static final int ZERO_LENGTH = 0;
    private static final int NOT_FOUND_BLANK = -1;
    private static final Pattern numericPattern = Pattern.compile("^[1-9]*$");
    private static final Pattern characterPattern = Pattern.compile("^[a-zA-Z]*$");
    private static final Pattern hangulPattern = Pattern.compile("^[ㄱ-ㅎ가-힣]*$");
    private static final Pattern hangulAndCharacterAndNumericPattern = Pattern.compile("^[a-zA-Z0-9ㄱ-ㅎ가-힣]*$");

    private RacingGameValidationImpl() {}

    private static class LazyHolder {
        public static final RacingGameValidationImpl INSTANCE = new RacingGameValidationImpl();
    }

    public static RacingGameValidationImpl getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void validCarNames(String inputTheCarNames) {
        String[] carNames = StringToStringArray(inputTheCarNames);
        for (String carName : carNames) {
            if (isContainsBlanks(carName) || !isLessThan5Length(carName) || isNull(carName) || isContainsSpecialCharacter(carName)) {
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
        return inputTheCarNames.split(",");
    }
}

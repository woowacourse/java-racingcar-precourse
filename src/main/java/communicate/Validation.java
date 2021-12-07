package communicate;

import java.util.ArrayList;

public class Validation {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final String REGEX_ONLY_NUMBER = "^[0-9]*$";
    private ArrayList<String> carNames;
    private String inputCarNames;
    private String attemptNumber;
    private String errorMessage;

    private void throwInputException() {
        throw new IllegalArgumentException();
    }

    private void checkCarNumber() {

        if (!inputCarNames.contains(Text.SEPARATOR_COMMA)) {
            errorMessage = ErrorText.ERROR_CAR_NUMBER;
            throwInputException();
        }

    }

    private void checkNameOnlySpace() {

        for (String name : carNames) {

            if (name.trim().length() == ZERO) {
                errorMessage = ErrorText.ERROR_NAME_ONLY_SPACE;
                throwInputException();
            }

        }

    }

    private int countSeparatorComma() {
        return inputCarNames.length() - inputCarNames.replace(Text.SEPARATOR_COMMA, Text.EMPTY_STRING).length();
    }

    private void checkNameEmpty() {

        if (countSeparatorComma() + ONE != carNames.size()) {
            errorMessage = ErrorText.ERROR_NAME_LENGTH;
            throwInputException();
        }

    }

    private void checkSpacePosition() {

        for (String name : carNames) {

            if (name.length() != name.trim().length()) {
                errorMessage = ErrorText.ERROR_NAME_SPACE_POSITION;
                throwInputException();
            }

        }

    }

    private void checkNameLength() {

        for (String name : carNames) {

            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                errorMessage = ErrorText.ERROR_NAME_LENGTH;
                throwInputException();
            }

        }

    }

    private void checkNameOverlap() {

        for (int i = carNames.size() - 1; i >= 0; i--) {

            if (carNames.indexOf(carNames.get(i)) != i) {
                errorMessage = ErrorText.ERROR_NAME_OVERLAP;
                throwInputException();
            }

        }

    }

    private void checkAttemptOnlyNumber() {

        if (!attemptNumber.matches(REGEX_ONLY_NUMBER) || attemptNumber.length() == ZERO) {
            errorMessage = ErrorText.ERROR_ATTEMPT_NOT_NUMBER;
            throwInputException();
        }

    }

    private void checkAttemptRange() {

        if (Integer.parseInt(attemptNumber) < MIN_ATTEMPT_NUMBER) {
            errorMessage = ErrorText.ERROR_ATTEMPT_NUMBER_RANGE;
            throwInputException();
        }

    }

    private void validateCarNames() {
        checkCarNumber();
        checkNameOnlySpace();
        checkNameEmpty();
        checkSpacePosition();
        checkNameLength();
        checkNameOverlap();
    }

    private void validateAttemptNumber() {
        checkAttemptOnlyNumber();
        checkAttemptRange();
    }

    public boolean isValidCarNames(String inputCarNames, ArrayList<String> carNames) {

        try {
            this.carNames = carNames;
            this.inputCarNames = inputCarNames;
            validateCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(errorMessage + Text.LINE_BREAK);

            return false;
        }

        return true;
    }

    public boolean isValidAttemptNumber(String attemptNumber) {

        try {
            this.attemptNumber = attemptNumber;
            validateAttemptNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(errorMessage + Text.LINE_BREAK);

            return false;
        }

        return true;
    }
}

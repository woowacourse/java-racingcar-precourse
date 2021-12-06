package communicate;

import java.util.ArrayList;

public class Validation {
    private static final int MIN_CAR_NUMBER = 2;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private ArrayList<String> carNames;
    private String errorMessage;

    private void throwInputException() {
        throw new IllegalArgumentException();
    }

    private void checkCarNumber() {

        if (carNames.size() < MIN_CAR_NUMBER) {
            errorMessage = ErrorText.ERROR_CAR_NUMBER;
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

    public boolean isValidCarNames(ArrayList<String> carNames) {

        try {
            this.carNames = carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(errorMessage + Text.LINE_BREAK);

            return false;
        }

        return true;
    }
}

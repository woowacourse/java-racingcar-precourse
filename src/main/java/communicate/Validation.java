package communicate;

import java.util.ArrayList;

public class Validation {
    private static final int MIN_CAR_NUMBER = 2;
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

package validator;

public class InputValidator {
    private static final int ZERO = 0;
    private static final int CAR_NAME_MAX_SIZE = 5;

    private int passCount = ZERO;

    public static InputValidator getInstance() {
        return new InputValidator();
    }

    public boolean checkCarNames(String[] userInput) {
        passCount = ZERO;
        for (int i = 0; i < userInput.length; i++) {
            checkCarNameSize(userInput[i]);
        }
        if (passCount == userInput.length)
            return true;
        return false;
    }

    private void checkCarNameSize(String input) {
        int length = input.length();
        if (length <= CAR_NAME_MAX_SIZE && length > ZERO)
            passCount++;
    }
}

package racingcar;

public class InputValidator {
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    public static void checkEachCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (MINIMUM_LENGTH <= carName.length() && carName.length() <= MAXIMUM_LENGTH) {
                continue;
            }

            UserScreen.showNameLengthError();
            System.exit(0);
        }
    }

    public static void checkIfSplitterAtStartOrEnd(String userString, String nameSplitter) {
        if (userString.charAt(0) == nameSplitter.charAt(0)
                || userString.charAt(userString.length() - 1) == nameSplitter.charAt(0)) {

            UserScreen.splitterStartOrEndError();
            System.exit(0);
        }
    }

    public static void checkIfNaturalNumber(String userString) {
        checkIfAllDigit(userString);
        checkIfFirstDigitIsZero(userString);
    }

    private static void checkIfFirstDigitIsZero(String userString) {
        if (userString.charAt(0) == '0') {
            UserScreen.showFirstDigitZeroError();
            System.exit(0);
        }
    }

    private static void checkIfAllDigit(String userString) {
        for (int i = 0; i < userString.length(); i++) {
            if ('0' <= userString.charAt(i) && userString.charAt(i) <= '9') {
                continue;
            }

            UserScreen.showNotDigitError();
            System.exit(0);
        }
    }
}

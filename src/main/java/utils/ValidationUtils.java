package utils;

public class ValidationUtils {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_NUMBER_OF_MOVES = 1;
    private static final int MAX_NUMBER_OF_MOVES = 100;
    private static final String CAR_NAME_DELIMITER = ",";
    // Regular expressions
    private static final String LOWERCASE_LETTERS = "a-z";
    private static final String UPPERCASE_LETTERS = "A-Z";
    private static final String NUMBERS = "0-9";
    private static final String CHARACTER_FORMAT = "[%s]";
    private static final String LENGTH_FORMAT = "{%d,%d}";
    private static final String CAR_NAMES_FORMAT = "^(%1$s)(%2$s%1$s)*$";

    private ValidationUtils() {
    }

    private static String allowCharacters(String characters) {
        return String.format(CHARACTER_FORMAT, characters);
    }

    private static String allowLength(int minLength, int maxLength) {
        return String.format(LENGTH_FORMAT, minLength, maxLength);
    }

    private static String buildRegularExpressionForCarNames() {
        String allowedCharacters = allowCharacters(LOWERCASE_LETTERS + UPPERCASE_LETTERS + NUMBERS);
        String allowedLength = allowLength(MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH);
        String allowedCarName = allowedCharacters + allowedLength;
        return String.format(CAR_NAMES_FORMAT, allowedCarName, CAR_NAME_DELIMITER);
    }

    public static boolean isValidCarNames(String carNames) {
        String regularExpressionForCarNames = buildRegularExpressionForCarNames();
        return carNames.matches(regularExpressionForCarNames);
    }

    public static boolean isNumeric(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    public static boolean isValidMovingRange(int numberOfMoves) {
        return numberOfMoves >= MIN_NUMBER_OF_MOVES && numberOfMoves <= MAX_NUMBER_OF_MOVES;
    }

    public static boolean isValidNumberOfMoves(String stringNumberOfMoves) {
        if (!isNumeric(stringNumberOfMoves)) {
            return false;
        }

        int numberOfMoves = Integer.parseInt(stringNumberOfMoves);
        if (!isValidMovingRange(numberOfMoves)) {
            return false;
        }

        return true;
    }
}

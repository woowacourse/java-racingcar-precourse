package racingcar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputNumberOfTryValidator {
    private static final String EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE = "[ERROR] 1번째 자리에는 0이 올 수 없습니다.";
    private static final String NON_NUMERIC_CHARACTERS_EXCEPTION_MESSAGE = "[ERROR] '숫자'만 입력 가능합니다.";
    private static final String DIGIT_OUT_OF_RANGE_EXCEPTION = "[ERROR] 숫자의 자릿수는 9자리를 초과할 수 없습니다.";
    private static final String NON_POSITIVE_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 양수만 입력할 수 있습니다.";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_FORM = "0\\d+";
    private static final String INPUT_NON_NUMBER_FORM = "\\D";
    private static final int MAX_LENGTH_OF_NUMBER_OF_TRY = 9;
    
    public static void validate(final String numberOfTry) {
        validateNullOrEmpty(numberOfTry);
        validateZeroAtFirstPlaceExist(numberOfTry);
        validateInputNumberFormatMatching(numberOfTry);
        validateDigitRangeOfOut(numberOfTry);
        validatePositive(numberOfTry);
    }
    
    private static void validateNullOrEmpty(final String numberOfTry) {
        InputCommonValidator.validate(numberOfTry);
    }
    
    private static void validateZeroAtFirstPlaceExist(final String inputNumber) {
        if (isExistZeroAtFirstPlace(inputNumber)) {
            throw new IllegalArgumentException(EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isExistZeroAtFirstPlace(final String inputNumber) {
        return matcher(inputNumber, EXIST_ZERO_AT_FIRST_PLACE_FORM).matches();
    }
    
    private static void validateInputNumberFormatMatching(final String inputNumber) {
        if (isNonNumericCharactersExist(inputNumber)) {
            throw new IllegalArgumentException(NON_NUMERIC_CHARACTERS_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isNonNumericCharactersExist(final String inputNumber) {
        return matcher(inputNumber, INPUT_NON_NUMBER_FORM).find();
    }
    
    private static void validateDigitRangeOfOut(final String numberOfTry) {
        if (isNumberDigitOutOfRange(numberOfTry)) {
            throw new IllegalArgumentException(DIGIT_OUT_OF_RANGE_EXCEPTION);
        }
    }
    
    private static boolean isNumberDigitOutOfRange(final String numberOfTry) {
        return numberOfTry.length() > MAX_LENGTH_OF_NUMBER_OF_TRY;
    }
    
    private static void validatePositive(final String numberOfTry) {
        if (Integer.parseInt(numberOfTry) <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
    
    private static Matcher matcher(final String inputNumber, final String correctInputForm) {
        return compiler(correctInputForm).matcher(inputNumber);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}

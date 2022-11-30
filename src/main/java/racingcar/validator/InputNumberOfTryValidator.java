package racingcar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputNumberOfTryValidator {
    private static final String EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE = "[ERROR] 1번째 자리에는 0이 올 수 없습니다.";
    private static final String NON_NUMERIC_CHARACTERS_EXCEPTION_MESSAGE = "[ERROR] '숫자'만 입력 가능합니다.";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_FORM = "0\\d+";
    private static final String INPUT_NON_NUMBER_FORM = "\\D";
    
    public static void validate(final String numberOfTry) {
        validateNullOrEmpty(numberOfTry);
        validateZeroAtFirstPlaceExist(numberOfTry);
        validateInputNumberFormatMatching(numberOfTry);
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
    
    private static Matcher matcher(final String inputNumber, final String correctInputForm) {
        return compiler(correctInputForm).matcher(inputNumber);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}

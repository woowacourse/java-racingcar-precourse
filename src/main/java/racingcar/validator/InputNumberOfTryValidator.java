package racingcar.validator;

public class InputNumberOfTryValidator {
    public static void validate(final String numberOfTry) {
        validateNullOrEmpty(numberOfTry);
    }
    
    private static void validateNullOrEmpty(final String numberOfTry) {
        InputCommonValidator.validate(numberOfTry);
    }
}

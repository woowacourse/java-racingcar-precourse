package racingcar.validator;

public class InputCarsNameValidator {
    public static void validate(final String carsName) {
        validateNullOrEmpty(carsName);
    }
    
    private static void validateNullOrEmpty(final String carsName) {
        InputCommonValidator.validate(carsName);
    }
}

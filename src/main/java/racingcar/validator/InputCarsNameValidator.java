package racingcar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCarsNameValidator {
    private static final String CARS_NAME_FORM_EXCEPTION_MESSAGE = "[ERROR] 차 이름 입력 형식이 올바르지 않습니다.";
    
    public static void validate(final String carsName) {
        validateNullOrEmpty(carsName);
        validateCarsNameForm(carsName);
    }
    
    private static void validateNullOrEmpty(final String carsName) {
        InputCommonValidator.validate(carsName);
    }
    
    private static void validateCarsNameForm(final String carsName) {
        final Matcher matcher = Pattern.compile("([a-z]+)(,[a-z]+)*").matcher(carsName);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(CARS_NAME_FORM_EXCEPTION_MESSAGE);
        }
    }
}

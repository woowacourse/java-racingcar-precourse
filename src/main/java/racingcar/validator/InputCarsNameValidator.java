package racingcar.validator;

import racingcar.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCarsNameValidator {
    private static final String CARS_NAME_FORM_EXCEPTION_MESSAGE = "[ERROR] 차 이름 입력 형식이 올바르지 않습니다.";
    private static final String CARS_NAME_FORM = "([a-z]{1,5})(,[a-z]{1,5})*";
    
    private InputCarsNameValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String carsName) {
        validateNullOrEmpty(carsName);
        validateCarsNameForm(carsName);
    }
    
    private static void validateNullOrEmpty(final String carsName) {
        InputCommonValidator.validate(carsName);
    }
    
    private static void validateCarsNameForm(final String carsName) {
        if (!matcher(carsName, CARS_NAME_FORM).matches()) {
            throw new IllegalArgumentException(CARS_NAME_FORM_EXCEPTION_MESSAGE);
        }
    }
    
    private static Matcher matcher(final String carsName, final String correctCarsNameForm) {
        return compiler(correctCarsNameForm).matcher(carsName);
    }
    
    private static Pattern compiler(final String correctCarsNameForm) {
        return Pattern.compile(correctCarsNameForm);
    }
}

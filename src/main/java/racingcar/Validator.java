package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int TRUE = 1;
    private static final int FALSE = 0;

    public static boolean isValidateInput(String input) {
        List<Car> inputCars = StringParser.parseStringToList(new ArrayList<>(), input);
        int isValid = TRUE;
        for (Car car : inputCars) {
            isValid *= isValidateName(car.getName());
        }
        return (isValid == TRUE);
    }

    private static int isValidateName(String name) {
        try {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NAME_ERROR_MESSAGE);
            return FALSE;
        }
        return TRUE;
    }

    public static boolean isValidateNumber(String input) {
        try {
            if (!isNumberFormat(input)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NUMBER_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

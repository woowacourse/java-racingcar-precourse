package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static boolean isValidateInput(String input) {
        List<Car> inputCars = GameUtil.parseStringToList(new ArrayList<>(), input);
        int isValid = CONSTANT.TRUE;
        for (Car car : inputCars) {
            isValid *= isValidateName(car.getName());
        }
        return (isValid == CONSTANT.TRUE);
    }

    private static int isValidateName(String name) {
        try {
            if (name.length() > CONSTANT.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NAME_ERROR_MESSAGE);
            return CONSTANT.FALSE;
        }
        return CONSTANT.TRUE;
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

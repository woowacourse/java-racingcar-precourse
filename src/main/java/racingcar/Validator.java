package racingcar;

import com.sun.org.apache.bcel.internal.Const;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static boolean isValidateInput(String input) {
        List<Car> inputCars = GameUtil.parseStringToList(new ArrayList<>(), input);
        int isValid = Constant.TRUE;
        for (Car car : inputCars) {
            isValid *= isValidateName(car.getName());
        }
        return (isValid == Constant.TRUE);
    }

    private static int isValidateName(String name) {
        try {
            if (name.length() > Constant.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NAME_ERROR_MESSAGE);
            return Constant.FALSE;
        }
        return Constant.TRUE;
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

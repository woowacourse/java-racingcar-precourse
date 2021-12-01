package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static boolean isValidateInput(String input) {
        List<Car> templist = parseStringToList(new ArrayList<>(), input);
        int flag = 1;
        for (Car car : templist) {
            flag *= isValidateName(car.getName());
        }
        return (flag == 1);
    }

    private static int isValidateName(String name) {
        try {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
            return 0;
        }
        return 1;
    }

    public static List<Car> parseStringToList(List<Car> list, String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            list.add(new Car(carName));
        }
        return list;
    }


    public static boolean isValidateNumber(String input) {
        try {
            if (!isNumberFormat(input)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
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

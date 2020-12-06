package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CarInputValidation {
    private static final int MIN_CAR_NAME_LENGTH = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String ERROR_CAR_NAME = "[ERROR] 경주할 자동차 이름이 올바르게 입력되지 않았습니다.";
    private static final String ERROR_CAR_DUPLICATE = "[ERROR] 경주할 자동차 이름이 중복됩니다.";

    public static String[] checkCarNameInput(String userInput) {
        String[] cars = userInput.split(",");
        checkCarDuplicate(cars);
        for (String car : cars) {
            checkEachCarName(car);
        }
        return cars;
    }

    private static void checkCarDuplicate(String[] cars) {
        boolean duplicate = checkDuplicateWithHashSet(cars);
        try {
            if (duplicate) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            System.err.println(ERROR_CAR_DUPLICATE);
            System.exit(0);
        }
    }

    private static boolean checkDuplicateWithHashSet(String[] cars) {
        Set<String> checkDuplicate = new HashSet<String>();
        for (String car : cars) {
            //중복된 원소가 있다
            if (checkDuplicate.contains(car)) {
                return true;
            }
            checkDuplicate.add(car);
        }
        return false;
    }

    private static void checkEachCarName(String car) {
        try {
            if ((car.length() == MIN_CAR_NAME_LENGTH) || (car.length() > MAX_CAR_NAME_LENGTH)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            System.err.println(ERROR_CAR_NAME);
            System.exit(0);
        }
    }
}

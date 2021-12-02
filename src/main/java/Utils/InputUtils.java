package Utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class InputUtils {

    public static List<Car> returnCarList() {
        List<Car> carList = new ArrayList<>();
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println(CAR_NAME_INPUT_MESSAGE);
                carList = getCarList();
                isValid = true;
            } catch (IllegalArgumentException e) {
            }
        }
        return carList;
    }

    private static List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        String input = Console.readLine();
        checkCarNameSentence(input);
        String[] carArr = input.split(CAR_NAME_SEPARATOR);

        for (String carName : carArr) {
            checkCarNameWord(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }

    private static void checkCarNameSentence(String input) {
        checkEmptyInput(input);
        checkInvalidCarNameInput(input);
    }

    private static void checkEmptyInput(String input) {
        if (input.isEmpty()) {
            System.out.println(ERROR_EMPTY_INPUT);
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    private static void checkInvalidCarNameInput(String input) {
        if ((input.charAt(input.length() - 1) == CAR_NAME_SEPARATOR.charAt(0))
                || input.contains(",,") || input.charAt(0) == CAR_NAME_SEPARATOR.charAt(0)) {
            System.out.println(ERROR_CAR_NAME_INPUT_ETC);
            throw new IllegalArgumentException(ERROR_CAR_NAME_INPUT_ETC);
        }
    }

    private static void checkCarNameWord(String carName) {
        checkCarNameLength(carName);
        checkCarNameFrontBlank(carName);
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            System.out.println(ERROR_CAR_NAME_LENGTH);
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    private static void checkCarNameFrontBlank(String carName) {
        if (carName.charAt(0) == ' ') {
            System.out.println(ERROR_CAR_NAME_FRONT_BLANK);
            throw new IllegalArgumentException(ERROR_CAR_NAME_FRONT_BLANK);
        }
    }

    public static int getAttempNum() {
        boolean isValid = false;
        String attempStr = null;
        while (!isValid) {
            try {
                System.out.println(ATTEMP_INPUT_MESSAGE);
                attempStr = Console.readLine();
                checkInvalidAttempNum(attempStr);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_INVALID_ATTEMP);
            }
        }
        return Integer.parseInt(attempStr);
    }

    private static void checkInvalidAttempNum(String attempStr) {
        for (int i = INITIAL_VALUE; i < attempStr.length(); i++) {
            if (!Character.isDigit(attempStr.charAt(i))) {
                throw new IllegalArgumentException(ERROR_INVALID_ATTEMP);
            }
        }
    }

}

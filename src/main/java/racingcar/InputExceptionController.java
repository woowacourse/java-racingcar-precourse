package racingcar;

import java.util.ArrayList;

public class InputExceptionController {
    private static int MAX_NAME_LENGTH = 5;
    private static String ERROR_MARK = "[ERROR]";

    public static boolean isDuplication(ArrayList<Car> cars, String participationCar) {
        return cars.contains(participationCar);
    }

    public static boolean isLengthExcess(String participationCar) {
        return participationCar.length() > MAX_NAME_LENGTH;
    }

    public static void checkInputCars(ArrayList<Car> cars, String participationCar) {

    }

    public static void checkInputTimes() {

    }

}

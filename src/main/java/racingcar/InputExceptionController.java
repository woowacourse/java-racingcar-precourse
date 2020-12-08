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
        if(isDuplication(cars,participationCar)){
            throw new IllegalArgumentException(ERROR_MARK+"중복된 이름이 있습니다.");
        }
        if(isLengthExcess(participationCar)){
            throw new IllegalArgumentException(ERROR_MARK+"이름이 5자를 초과했습니다.");
        }
    }

    public static void checkInputTimes() {

    }

}

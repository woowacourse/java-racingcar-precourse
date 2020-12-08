package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class InputExceptionController {
    private static int MAX_NAME_LENGTH = 5;
    private static int MIN_PARTICIPATION_NUMBER = 2;
    private static String ERROR_MARK = "[ERROR]";

    public static boolean isDuplication(ArrayList<Car> cars, String participationCar) {
        for (Car car : cars){
            if (car.getCarName().equals(participationCar)){
                return true;
            }
        }
        return false;
    }

    public static boolean isLengthExcess(String participationCar) {
        return participationCar.length() > MAX_NAME_LENGTH;
    }

    public static boolean isParticipationLess(ArrayList<Car> cars){
        return cars.size() < MIN_PARTICIPATION_NUMBER;
    }

    public static void checkInputCars(ArrayList<Car> cars, String participationCar) {
        if(isDuplication(cars,participationCar)){
            throw new IllegalArgumentException(ERROR_MARK+"중복된 이름이 있습니다.");
        }
        if(isLengthExcess(participationCar)){
            throw new IllegalArgumentException(ERROR_MARK+"이름이 5자를 초과했습니다.");
        }
    }

    public static void checkParticipation(ArrayList<Car> cars) {
        if(isParticipationLess(cars)){
            throw new IllegalArgumentException(ERROR_MARK+"참가 인원이 부족합니다.");
        }
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class InputUtils {

    public static List<Car> returnCarList() {
        List<Car> carList = new ArrayList<>();
        boolean isValid = false;

        while (!isValid) {
            try {
                carList = getCarList();
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_CAR_NAME_LENGTH);
            }
        }
        return carList;
    }

    private static List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        String[] carArr = Console.readLine().split(CAR_NAME_SEPARATOR);

        for (String carName : carArr) {
            checkCarNameLength(carName);
            carList.add(new Car(carName));
        }

        return carList;
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

}

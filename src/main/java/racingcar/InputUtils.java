package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUtils {

    public static List<Car> returnCarList() {
        List<Car> carList = new ArrayList<>();
        boolean isValid = false;

        while (!isValid) {
            try {
                carList = getCarList();
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return carList;
    }

    private static List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        String[] carArr = Console.readLine().split(",");

        for (String carName : carArr) {
            checkCarNameLength(carName);
            carList.add(new Car(carName));
        }

        return carList;
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }

}

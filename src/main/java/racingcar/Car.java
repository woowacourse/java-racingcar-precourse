package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    private static List<Car> carList = new ArrayList<>();

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static List<Car> makeCarList(String userInput) {
        List<String> userList = CheckValidation.stringToList(userInput);
        for (String car : userList) {
            carList.add(new Car(car, 0));
        }
        return carList;
    }


}

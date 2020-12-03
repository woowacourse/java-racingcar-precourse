package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    private static List<Car> carList = new ArrayList<>();

    public Car(String name) {
        this.name = name;
    }

    public static List<Car> makeCarList(String userInput) {
        List<String> userList = CheckValidation.stringToList(userInput);
        for (String car : userList) {
            carList.add(new Car(car));
        }
        return carList;
    }

    
}

package racingcar;

import java.util.Arrays;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    private List<Car> carList;

    public Car(String name) {
        this.name = name;
    }

    public List<Car> makeCarList(String userInput) {
        List<String> userList = CheckValidation.stringToList(userInput);
        for (String car : userList) {
            carList.add(new Car(car));
        }
        return carList;
    }

}

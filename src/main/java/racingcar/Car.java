package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static List<Car> generateCars(List<String> names) {
        List<Car> result = new ArrayList<>();

        for (String name : names) {
            validateName(name);
            result.add(new Car(name));
        }

        return result;
    }

    private static void validateName(String name) {
        if(name.length() > Const.MAX_NAME_COUNT)
            throw new IllegalArgumentException();
    }
}

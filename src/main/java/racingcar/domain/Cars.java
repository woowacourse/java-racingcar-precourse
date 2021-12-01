package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.ValidationUtil;

public class Cars {
    public static final String DELIMITER = ",";

    private final List<Car> cars;

    private Cars(String carsName) {
        ValidationUtil.checkEmpty(carsName);
        this.cars = Arrays.stream(carsName.split(DELIMITER))
            .map(name -> {
                ValidationUtil.checkName(name);
                return new Car(name);
            }).collect(Collectors.toList());
    }

    public static Cars createByNames(String carsName) {
        return new Cars(carsName);
    }
}

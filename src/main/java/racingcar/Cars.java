package racingcar;

import racingcar.validator.CarValidator;

import javax.xml.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars() {
    }

    public void createCars(String racingCarNames) {
        CarValidator.validate(racingCarNames);
        cars = Arrays.stream(racingCarNames.split(CarValidator.DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

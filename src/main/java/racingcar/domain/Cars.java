package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.exception.CarNameValidator;
import racingcar.domain.exception.Validator;

public class Cars {
    private static final String COMMA = ",";
    private List<Car> cars;

    public Cars(String names) {
        cars = new ArrayList<>();
        CarNameValidator validator = new Validator();
        String[] nameArr = names.split(COMMA);
        if (validator.isAllValid(nameArr)) {
            for (String name : nameArr) {
                cars.add(createCar(name));
            }
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    public void play(RepetitionNumber distance) {
        for (Car car : cars) {
            car.drive(distance.getRepetitionNumber());
        }
    }
}

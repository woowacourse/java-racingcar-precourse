package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    private static final String CAR_NAME_SPLIT_REGEX = ",";

    private List<Car> racingCars = new ArrayList<>();

    public void generateRacingCars(String inputCarName) {
        for (String carName : inputCarName.split(CAR_NAME_SPLIT_REGEX)) {
            Car generatedCar = new Car(carName);
            racingCars.add(generatedCar);
        }
    }
}

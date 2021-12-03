package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public List<Car> createCars(String[] carNameStrings) {
        List<Car> carNames = new ArrayList<>();
        for (String carNameString : carNameStrings) {
            carNames.add(Car.create(carNameString));
        }
        return carNames;
    }
}

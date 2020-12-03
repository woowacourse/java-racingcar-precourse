package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRace {
    private List<Car> racingCars;

    public CarRace(String carName) {
        racingCars = new ArrayList<>();

        String[] carNames = carName.replace(" ", "").split(",");
        for (String s : carNames) {
            racingCars.add(new Car(s));
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}

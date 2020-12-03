package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> cars;

    public CarList(String[] carNames) {
        cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}

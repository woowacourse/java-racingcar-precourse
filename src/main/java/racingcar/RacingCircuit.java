package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCircuit {

    private final List<Car> carList;

    public RacingCircuit(String[] carNameArray) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameArray) {
            carList.add(new Car(carName));
        }
        this.carList = carList;
    }


    public List<Car> getCarList() {
        return carList;
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList = new ArrayList<>();

    public CarList(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }
}

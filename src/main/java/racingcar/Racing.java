package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public List<Car> makeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public List<Car> oneTrialGame(List<Car> carList) {
        for (Car car : carList) {
            car.tryMove();
        }
        return carList;
    }

}

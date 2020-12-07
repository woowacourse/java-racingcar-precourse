package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceCars {
    private final List<Car> raceCarList;

    public RaceCars() {
        this.raceCarList = new ArrayList<>();
    }

    public List<Car> getRaceCars() {
        return raceCarList;
    }

    public void setRaceCars(List<String> cars) {
        for (String carName : cars) {
            raceCarList.add(new Car(carName));
        }
    }
}

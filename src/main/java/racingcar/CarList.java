package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<String> carList) {
        for (String carName : carList) {
            this.carList.add(new Car(carName));
        }
    }
}

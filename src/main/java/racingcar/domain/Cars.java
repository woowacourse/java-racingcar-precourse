package racingcar.domain;

import java.util.List;

public class Cars {
    CarList carList = new CarList();
    TryNumber tryNumber = new TryNumber();

    public List<Car> getCarList() {
        return carList.getCarList();
    }

    public int getTryNumber() {
        return Integer.parseInt(this.tryNumber.getTryNumber());
    }

    public void setTryNumber(String tryNumber) {
        this.tryNumber.setTryNumber(tryNumber);
    }

    public void addCars(String carNames) {
        for (String carName : carNames.split(",")) {
            carList.add(carName);
        }
    }
}

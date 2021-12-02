package racingcar.domain;

import racingcar.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    CarList carList = new CarList();
    TryNumber tryNumber = new TryNumber();

    public void addCar(String carNames) {
        for (String carName : carNames.split(",")) {
            carList.add(carName);
        }
    }

    public void setTryNumber(String tryNumber) {
        this.tryNumber.setTryNumber(tryNumber);
    }
}

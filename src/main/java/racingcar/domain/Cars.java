package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.StrictMath.max;

public class Cars {
    private final CarList carList = new CarList();
    private final TryNumber tryNumber = new TryNumber();

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
        isCarListNull();
    }

    public int getCarsPosition() {
        List<Integer> carPositionList = new ArrayList<Integer>();
        for (Car car : carList.getCarList()) {
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

    public String getWinner(int maxPosition) {
        List<String> winnerList = new ArrayList<String>();

        for (Car car : carList.getCarList()) {
            if (maxPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return String.join(", ", winnerList);
    }

    private void isCarListNull() throws IllegalArgumentException {
        if (this.carList.getCarList().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.print());
        }
    }
}

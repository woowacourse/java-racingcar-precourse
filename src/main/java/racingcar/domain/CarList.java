package racingcar.domain;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList = new ArrayList<Car>();

    public void add(String carName) throws IllegalArgumentException {
        carNameValidation(carName);
        carList.add(new Car(carName));
    }

    public void carNameValidation(String carName) throws IllegalArgumentException {
        isNull(carName);
        isOverSizeCarName(carName);
    }

    public static void isOverSizeCarName(String carName) throws IllegalArgumentException {
        if (carName.length() > Constant.CAR_NAME_MAX_SIZE.value()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_SIZE_ERROR.print());
        }
    }

    public static void isNull(String carName) throws IllegalArgumentException {
        if (carName.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.print());
        }
    }
}

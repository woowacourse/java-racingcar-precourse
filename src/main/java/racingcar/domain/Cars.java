package racingcar.domain;

import racingcar.view.ErrorViewer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

public class Cars {
    private final ArrayList<Car> carList = new ArrayList<Car>();

    public Cars(String[] carNames) {
        checkOverlap(carNames);
        for (String carName : carNames) {
            Car tempCar = new Car(carName);
            carList.add(tempCar);
        }
    }

    private void checkOverlap(String[] carNames) {
        HashSet<String> checkOverlapSet = new HashSet<>(Arrays.asList(carNames));
        if (checkOverlapSet.size() != carNames.length) {
            ErrorViewer.showCarsInputError();
        }
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    /*게임 한턴을 진행시켜주는 메서드 */
    public void processOneTurn() {
        carList.forEach(Car::playOneTurn);
    }
}

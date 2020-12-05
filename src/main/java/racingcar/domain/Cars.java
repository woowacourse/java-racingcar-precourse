package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.view.InputViewer;

public class Cars {
    private List<Car> carList;

    public Cars(String[] carNames) {
        checkOverlap(carNames);
        for (String carName : carNames) {
            Car tempCar = new Car(carName);
            this.carList.add(tempCar);
        }
    }

    private void checkOverlap(String[] carNames) {
        HashSet<String> checkOverlapSet = new HashSet<>(Arrays.asList(carNames));
        if (checkOverlapSet.size() != carNames.length) {
            InputViewer.carsInputError();
        }
    }
}

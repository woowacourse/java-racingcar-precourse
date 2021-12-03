package racingcar;

import java.util.List;
import java.util.ArrayList;

public class CarEntry {
    private final List<String> carList;
    private final int nOfCars;

    public CarEntry(String carNames) {
        String[] carNameArray = getCarNameArray(carNames);
        nOfCars = carNameArray.length;
        carList = new ArrayList<>(nOfCars);
        for (int i = 0; i < nOfCars; i++) {
            carList.add(i, carNameArray[i]);
        }
    }

    private String[] getCarNameArray(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (int i = 0; i < nOfCars; i++) {
            carNameArray[i] = carNameArray[i].trim();
        }
        return carNameArray;
    }
}

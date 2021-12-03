package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CarEntry {
    private final List<Car> carList;
    private final int nOfCars;

    public CarEntry(String carNames) {
        String[] carNameArray = getCarNameArray(carNames);
        nOfCars = carNameArray.length;
        carList = new ArrayList<Car>(nOfCars);
        for (int i = 0; i < nOfCars; i++) {
            carList.add(i, new Car(carNameArray[i]));
        }
    }

    public void letCarsMove() {
        Stream<Car> stream = carList.stream();
        stream.forEach(Car::progressOrStop);
    }

    public void printCurCarsPosition() {
        Stream<Car> stream = carList.stream();
        stream.forEach(Car::printCurrentPosition);
    }

    private String[] getCarNameArray(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (int i = 0; i < nOfCars; i++) {
            carNameArray[i] = carNameArray[i].trim();
        }
        return carNameArray;
    }
}

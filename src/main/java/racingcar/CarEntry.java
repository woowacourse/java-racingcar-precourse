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
            carList.add(new Car(carNameArray[i]));
        }
    }

    public void letCarsMove() {
        Stream<Car> carStream = carList.stream();
        carStream.forEach(Car::progressOrStop);
    }

    public void printCurCarsPosition() {
        Stream<Car> carStream = carList.stream();
        carStream.forEach(Car::printCurrentPosition);
    }

    public void printWinners() {
        List<Car> winnerList = getWinners();
        System.out.print("최종 우승자 : ");
        int nOfWinners = winnerList.size();
        for (int i = 0; i < nOfWinners - 1; i++) {
            System.out.print(winnerList.get(i).getName());
            System.out.print(", ");
        }
        System.out.println(winnerList.get(nOfWinners - 1).getName());
    }

    private List<Car> getWinners() {
        List<Car> winnerList = new ArrayList<Car>();
        int winnerDistance = getWinnerDistance();
        for (int i = 0; i < nOfCars; i++) {
            Car currentCar = carList.get(i);
            if (currentCar.getPosition() == winnerDistance) {
                winnerList.add(currentCar);
            }
        }
        return winnerList;
    }

    private int getWinnerDistance() {
        int leadingDistance = 0;
        for (int i = 0; i < nOfCars; i++) {
            Car currentCar = carList.get(i);
            if (currentCar.getPosition() > leadingDistance)
                leadingDistance = currentCar.getPosition();
        }
        return leadingDistance;
    }

    private String[] getCarNameArray(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (int i = 0; i < carNameArray.length; i++) {
            carNameArray[i] = carNameArray[i].trim();
        }
        return carNameArray;
    }
}

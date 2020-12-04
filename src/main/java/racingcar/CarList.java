package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.CarListUtils;

public class CarList implements Iterable<Car> {
    private List<Car> carList;

    public CarList(String[] carNames) {
        carList = new ArrayList<Car>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public void moveAllCars() {
        for (Car car : carList) {
            car.attemptToMove(CarListUtils.getRandomValue());
        }
    }

    public List<String> getWinners() {
        int maximumPosition = CarListUtils.getMaximumPosition(carList);
        List<String> winners = CarListUtils.getCarNamesAtPosition(carList, maximumPosition);
        return winners;
    }

    @Override
    public Iterator<Car> iterator() {
        return carList.iterator();
    }
}

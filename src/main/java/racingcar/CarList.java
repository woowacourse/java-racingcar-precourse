package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import utils.RandomUtils;

public class CarList implements Iterable<Car> {
    private static final int RANDOM_MINIMUM = 1;
    private static final int RANDOM_MAXIMUM = 9;

    private List<Car> carList;

    public CarList(String[] carNames) {
        carList = new ArrayList<Car>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public void moveAllCars() {
        for (Car car : carList) {
            car.attemptToMove(getRandomValue());
        }
    }

    private int getRandomValue() {
        return RandomUtils.nextInt(RANDOM_MINIMUM, RANDOM_MAXIMUM);
    }

    public List<String> getWinners() {
        int maximumPosition = getMaximumPosition();
        List<String> winners = getCarNamesOfPosition(maximumPosition);
        
        return winners;
    }

    private int getMaximumPosition() {
        return carList.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }
    
    private List<String> getCarNamesOfPosition(int position) {
        List<String> carNames = new ArrayList<String>();
        for (Car car : carList) {
            if (car.getPosition() == position) {
                carNames.add(car.getName());
            }
        }

        return carNames;
    }

    @Override
    public Iterator<Car> iterator() {
        return carList.iterator();
    }
}

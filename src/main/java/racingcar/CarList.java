package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarList {
    private final List<Car> racingCars;

    public CarList() {
        racingCars = new ArrayList<>();
    }

    public void addRacingCarEntity(Car car) {
        racingCars.add(car);
    }

    private void sortEntities() {
        Collections.sort(racingCars);
    }

    public void printCarPosition() {
        for (Car car : racingCars) {
            if(car.isPossibleMoveForward(car.generateRandomValue())) car.updatePosition();
            System.out.println(car);
        }
        System.out.println();
    }

    public List<Car> determineWinner() {
        List<Car> results = new ArrayList<>();
        sortEntities();
        int maxValue = racingCars.get(0).getPosition();
        for(Car racingCar: racingCars) {
            if (racingCar.getPosition() < maxValue) break;
            results.add(racingCar);
        }
        return results;
    }
}

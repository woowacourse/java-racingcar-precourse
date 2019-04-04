package com.nekisse;

import com.nekisse.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WiningCars {
    private List<Car> winingCars;

    public List<Car> getWiningCars() {
        return winingCars;
    }

    public WiningCars(GameMachine gameMachine) {
        this.winingCars = setUpWiningCars(gameMachine.getCars());
    }

    protected List<Car> setUpWiningCars(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxMovedPosition = getMaxMovedPosition(cars);
        for (Car car : cars) {
            addWinners(winners, maxMovedPosition, car);
        }
        return winners;
    }

    private int getMaxMovedPosition(List<Car> cars) {
        int position = 0;
        for (Car car : cars) {
            position = car.compareToMovePosition(position);
        }
        return position;
    }

    private void addWinners(List<Car> winners, int highScore, Car car) {
        if (car.isMaxPosition(highScore)) {
            winners.add(car);
        }
    }


}

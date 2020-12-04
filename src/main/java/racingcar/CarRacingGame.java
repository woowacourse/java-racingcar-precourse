package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame implements RacingGame {
    private List<Car> carList = new ArrayList<>();
    private int carMoveAttemptCount;

    public CarRacingGame() { }

    @Override
    public void addCar(Car car) {
        carList.add(car);
    }

    @Override
    public void startRacingGame() {

    }

    @Override
    public void printWinner() {

    }
}

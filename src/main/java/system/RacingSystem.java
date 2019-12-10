package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;
import util.Numbers;

import java.util.ArrayList;
import java.util.List;

public class RacingSystem {
    private static final int MOVE_CONDITION = 4;

    private final List<Car> racingCars;

    public RacingSystem(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public void startRacing() {
        int repeatTimes = InputRacingCar.inputRepeatTimes();

        OutputRacingCar.printGameResult();
        while (repeatTimes-- > 0) {
            race();
            System.out.println();
        }
    }

    private void race() {
        for (Car car : racingCars) {
            decideToMoveCar(car);
            OutputRacingCar.printCarProgress(car);
        }
    }

    private void decideToMoveCar(Car car) {
        if (Numbers.getRandomNumber() >= MOVE_CONDITION) {
            car.move();
        }
    }
}
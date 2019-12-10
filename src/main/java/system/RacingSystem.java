package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;
import util.RandomNumberGenerator;

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
        for (int i = 0; i < repeatTimes; i++) {
            race();
        }
    }

    private void race() {
        for (Car car : racingCars) {
            decideToMoveCar(car);
            OutputRacingCar.printCarProgress(car);
        }
        System.out.println();
    }

    private void decideToMoveCar(Car car) {
        if (RandomNumberGenerator.getRandomNumber() >= MOVE_CONDITION) {
            car.move();
        }
    }
}
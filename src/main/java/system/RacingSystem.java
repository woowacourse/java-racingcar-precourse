package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingSystem {
    private static final int MOVE_CONDITION = 4;

    private List<Car> cars;

    public RacingSystem(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void startRacing() {
        int repeatTimes = InputRacingCar.inputRepeatTimes();
        OutputRacingCar.printGameResult();
        for (int i = 0; i < repeatTimes; i++) {
            race();
        }
    }

    public void race() {
        for (Car car : cars) {
            decideToMoveCar(car);
            OutputRacingCar.printCarProgress(car);
        }
        System.out.println();
    }

    public void decideToMoveCar(Car car) {
        if (RandomNumberGenerator.getRandomNumber() >= MOVE_CONDITION) {
            car.move();
        }
    }
}

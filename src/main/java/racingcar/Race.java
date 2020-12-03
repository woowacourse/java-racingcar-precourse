package racingcar;

import domain.Car;
import utils.DigitStrategy;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int round;

    public Race(List<Car> cars, int round) {
        this.cars = new ArrayList<>(cars);
        this.round = round;
    }

    public RaceResult startRace(DigitStrategy digitStrategy) {
        for (int i = 0; i < round; i++) {
            makeCarRun(digitStrategy);
            printCurrentPosition();
        }
        return RaceResult.of(cars);
    }

    private void makeCarRun(DigitStrategy digitStrategy) {
        cars.forEach(car -> car.run(digitStrategy.getDigit()));
    }

    private void printCurrentPosition() {
        cars.forEach(Printer::printCurrentPosition);
        System.out.println();
    }
}

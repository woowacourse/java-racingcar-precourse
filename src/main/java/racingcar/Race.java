package racingcar;

import domain.Car;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    protected List<Car> cars;
    private int round;

    public Race(List<Car> cars, int round) {
        this.cars = new ArrayList<>(cars);
        this.round = round;
    }

    public List<String> start() {
        for (int i = 0; i < round; i++) {
            makeCarRun();
            printCurrentPosition();
        }
        return RaceResult.getResult(cars);
    }

    protected abstract void makeCarRun();   //달리는 방식은 자식 객체에서 정한다.

    private void printCurrentPosition() {
        cars.forEach(Printer::printCurrentPosition);
        System.out.println();
    }
}

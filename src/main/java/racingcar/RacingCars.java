package racingcar;

import java.util.List;
import view.OutputView;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveFor(int roundCount) {
        OutputView.printRaceResultLabel();
        for (int i = 0; i < roundCount; ++i) {
            moveCars();
            OutputView.printCarPositionGraphic(this);
        }
    }

    private void moveCars() {
        cars.forEach(Car::move);
    }

    public void printResult() {
        cars.forEach(System.out::println);
    }
}

package racingcar;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import view.OutputView;

public class RacingCars {

    private static final String DELIMITER = ",";

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

    public String getWinners() {
        return cars.stream()
                .filter(x -> x.getPosition() == getWinningPosition())
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    public int getWinningPosition() {
        Optional<Integer> maxPosition =  cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare);
        return maxPosition.orElse(0);
    }
}

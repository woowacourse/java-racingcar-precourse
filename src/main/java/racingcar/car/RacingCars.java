package racingcar.car;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import view.OutputView;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(String rawCarNames) {
        CarNames.validate(rawCarNames);
        cars = Stream.of(rawCarNames.split(CarNames.NAME_SEPARATOR))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
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

    public String getWinners() {
        return cars.stream()
                .filter(x -> x.isPosition(getWinningPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(CarNames.NAME_SEPARATOR));
    }

    private int getWinningPosition() {
        Optional<Integer> maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare);
        return maxPosition.orElse(0);
    }

    public void printResult() {
        cars.forEach(System.out::println);
    }
}

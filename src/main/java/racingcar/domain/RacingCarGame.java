package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.OutputFormatter;

public class RacingCarGame {

    final private List<Car> cars;

    public RacingCarGame(List<String> names) {
        this.cars = names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(this::move);
    }

    private void move(Car car) {
        if (new MoveTicket().isValidTicket()) {
            car.moveForward();
        }
    }

    public String getGameStatus() {
        List<String> statusList = this.cars.stream()
            .map(Car::getCarStatus)
            .collect(Collectors.toList());
        return OutputFormatter.converseGameStatus(statusList);
    }

    public String getWinners() {
        final int top = getWinnerScore();
        List<String> winners = this.cars.stream()
            .filter(car -> car.getPosition() == top)
            .map(Car::getName)
            .collect(Collectors.toList());
        return OutputFormatter.convertWinners(winners);
    }

    private int getWinnerScore() {
        return this.cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalArgumentException::new);
    }
}

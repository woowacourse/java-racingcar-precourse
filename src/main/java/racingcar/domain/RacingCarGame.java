package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    final private List<Car> cars;
    final private Integer playCount;

    public RacingCarGame(List<String> names, int playCount) {
        this.cars = names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        this.playCount = playCount;
    }

    public void runCars() {
        cars.forEach(this::run);
    }

    private void run(Car car) {
        if (!new MoveTicket().isValidTicket()) {
            car.moveForward();
        }
    }

}

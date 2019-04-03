package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int remainingPlayCount;
    private Recorder recorder = new Recorder();

    private RacingCarGame(List<Car> cars, int remainingPlayCount) {
        this.cars = cars;
        this.remainingPlayCount = remainingPlayCount;
    }

    public static RacingCarGame of(List<String> carNames, int remainingPlayCount) {
        List<Car> cars = carNames.stream()
                .map(Car::fromName)
                .collect(Collectors.toList());
        return new RacingCarGame(cars, remainingPlayCount);
    }

    public void play() {
        while (!isGameOver()) {
            changeCount();
            cars.stream()
                    .filter(Car::isMovable)
                    .forEach(Car::move);
            recorder.saveRecord(cars);

        }
    }

    private boolean isGameOver() {
        return remainingPlayCount <= 0;
    }

    private void changeCount() {
        remainingPlayCount--;
    }

    public Recorder getRecorder() {
        return recorder;
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElseThrow(RuntimeException::new);
    }


}

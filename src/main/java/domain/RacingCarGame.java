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
            cars.stream()
                    .filter(Car::isMovable)
                    .forEach(Car::move);

            recorder.saveRecord(cars);
        }
    }

    private boolean isGameOver() {
        return remainingPlayCount-- <= 0;
    }

    public Recorder getRecorder() {
        return recorder;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElseThrow(RuntimeException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }


}

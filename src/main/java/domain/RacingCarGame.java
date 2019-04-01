package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int remainingPlayCount;
    private List<Result> results = new ArrayList<>();

    private RacingCarGame(List<Car> cars, int remainingPlayCount) {
        this.cars = cars;
        this.remainingPlayCount = remainingPlayCount;
    }

    public static RacingCarGame of(String carNamesWithComma, int remainingPlayCount) {
        String[] carNames = carNamesWithComma.split(",");
        List<Car> cars = Arrays.stream(carNames)
                                    .map(Car::fromName)
                                    .collect(Collectors.toList());
        return new RacingCarGame(cars, remainingPlayCount);
    }

    public void play() {
        while (!isGameOver()) {
            cars.stream()
                    .filter(Car::isMovable)
                    .forEach(Car::move);

            results.add(new Result(cars));
        }
    }

    private boolean isGameOver() {
        return remainingPlayCount-- <= 0;
    }

    public List<Result> getResults() {
        return results;
    }
}

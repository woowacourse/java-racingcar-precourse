package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int remainingPlayCount;

    public RacingCarGame(List<Car> cars, int remainingPlayCount) {
        this.cars = cars;
        this.remainingPlayCount = remainingPlayCount;
    }

    public static RacingCarGame of(String carNamesWithComma, int remainingPlayCount) {
        String[] carNames = carNamesWithComma.split(",");
        List<Car> cars = Arrays.stream(carNames)
                                    .map(Car::new)
                                    .collect(Collectors.toList());
        return new RacingCarGame(cars, remainingPlayCount);
    }

    public void play() {
        System.out.println("RacingCarGame.play Called");
    }
}

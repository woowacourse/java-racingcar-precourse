package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Car> cars;
    private int raceCount;

    public Game(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void play() {
        for (int i = 0; i < raceCount; i++) {
            moveOneRound();
        }

        printWinnerNames();
    }

    private void moveOneRound() {
        for (Car car: cars) {
            car.move();
        }

        System.out.println("");
    }

    private void printWinnerNames() {
        String winnerNames = String.join(", ", getWinnerNames());
        System.out.printf("최종 우승자 : %s%n", winnerNames);
    }

    private List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(x -> x.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int max = 0;
        int currentPosition;

        for (Car car : cars) {
            currentPosition = car.getPosition();

            if (max < currentPosition) max = currentPosition;
        }

        return max;
    }
}

package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {

    private final Scanner scanner;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        int tryCount;
        List<Car> cars;

        cars = getCars(getInput());
        tryCount = getTryCount();

        Winners winners = Race.start(cars, tryCount);
    }

    private int getTryCount() {
        int tryCount = 0;

        while (tryCount <= 0) {
            try {
                tryCount = Integer.parseInt(getInput());
            } catch (Exception e) {
                System.out.println("[ERROR] 다시 입력");
            }
        }
        return tryCount;
    }

    private List<Car> getCars(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String getInput() {
        return scanner.nextLine();
    }

}

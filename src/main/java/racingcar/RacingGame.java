package racingcar;

import static racingcar.Messages.TRY_COUNT_IS_NUMBER_ONLY;
import static utils.PrintUtils.printErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {

    private final Scanner scanner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        getReady();
        GameResult gameResult = Race.start(cars, tryCount);
        gameResult.printWinners();
    }

    private void getReady() {
        cars = getCars();
        tryCount = getTryCount();
    }

    private int getTryCount() {
        int tryCount = 0;

        while (tryCount <= 0) {
            try {
                tryCount = Integer.parseInt(getInput());
            } catch (Exception e) {
                printErrorMessage(TRY_COUNT_IS_NUMBER_ONLY);
            }
        }
        return tryCount;
    }

    private List<Car> getCars() {
        return Arrays.stream(getInput().split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String getInput() {
        return scanner.nextLine();
    }

}

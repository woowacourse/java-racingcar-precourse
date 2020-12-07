package racingcar;

import static racingcar.Messages.HOW_MANY_TIME_TO_TRY;
import static utils.PrintUtils.print;

import exceptions.TryCountInvalidInputException;
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
        getCarsReady();
        getTryCountReady();
    }

    private void getTryCountReady() {
        int tryCount = 0;
        print(HOW_MANY_TIME_TO_TRY);

        while (tryCount <= 0) {

            try {
                tryCount = Integer.parseInt(getInput());
            } catch (NumberFormatException e) {
                throw new TryCountInvalidInputException();
            }

            if (tryCount < 1) {
                throw new TryCountInvalidInputException();
            }

        }
        this.tryCount = tryCount;
    }

    private void getCarsReady() {
        // todo 입력 예외처리
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = Arrays.stream(getInput().split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = cars;
    }

    private String getInput() {
        return scanner.nextLine();
    }

}

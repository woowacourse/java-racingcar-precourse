package racingcar;

import static racingcar.Messages.HOW_MANY_TIME_TO_TRY;
import static racingcar.Messages.PLEASE_INPUT_NAMES_OF_CAR;
import static utils.PrintUtils.print;

import exceptions.InvalidInputException;
import exceptions.TryCountInvalidInputException;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private final Scanner scanner;
    private List<Car> cars;
    private Integer tryCount;

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

    private void getCarsReady() {
        print(PLEASE_INPUT_NAMES_OF_CAR);
        while (cars == null) {
            try {
                cars = Cars.getCars(getInput());
            } catch (InvalidInputException e) {
                print(e.getMessage());
            }
        }
    }

    private void getTryCountReady() {
        print(HOW_MANY_TIME_TO_TRY);
        while (tryCount == null) {
            try {
                tryCount = getTryCountByInput(getInput());
            } catch (TryCountInvalidInputException e) {
                print(e.getMessage());
            }
        }
    }

    private int getTryCountByInput(String input) throws TryCountInvalidInputException {
        // todo 개선 필요: 입력값 검증은 다른 객체로 역할 분리 고려
        int tryCount;

        try {
            tryCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new TryCountInvalidInputException();
        }

        if (tryCount < 1) {
            throw new TryCountInvalidInputException();
        }
        return tryCount;
    }

    private String getInput() {
        return scanner.nextLine();
    }
}

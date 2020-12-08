package racingcar;

import static racingcar.Messages.PLEASE_INPUT_TURNS;
import static racingcar.Messages.PLEASE_INPUT_NAMES_OF_CAR;
import static racingcar.Messages.TRY_COUNT_IS_NATURAL_NUMBER_ONLY;
import static racingcar.Messages.TRY_COUNT_IS_INTEGER_ONLY;
import static utils.PrintUtils.print;

import exceptions.InvalidInputException;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private final Scanner scanner;
    private List<Car> cars;
    private Integer turns;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        getReady();
        GameResult gameResult = Race.start(cars, turns);
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
        print(PLEASE_INPUT_TURNS);
        while (turns == null) {
            try {
                turns = getTryCountByInput(getInput());
            } catch (InvalidInputException e) {
                print(e.getMessage());
            }
        }
    }

    private int getTryCountByInput(String input) throws InvalidInputException {
        // todo 개선 필요: 입력값 검증은 다른 객체로 역할 분리 고려
        int tryCount;

        try {
            tryCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(TRY_COUNT_IS_INTEGER_ONLY);
        }

        if (tryCount < 1) {
            throw new InvalidInputException(TRY_COUNT_IS_NATURAL_NUMBER_ONLY);
        }
        return tryCount;
    }

    private String getInput() {
        return scanner.nextLine();
    }
}

package racingcar;

import static racingcar.Messages.TRY_COUNT_IS_NUMBER_ONLY;
import static utils.PrintUtils.print;
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
        print("시도할 회수는 몇회인가요?");

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
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(getInput().split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String getInput() {
        return scanner.nextLine();
    }

}

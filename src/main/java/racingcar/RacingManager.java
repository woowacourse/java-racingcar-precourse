package racingcar;

import java.util.Scanner;

public class RacingManager {
    public static void startRace(Scanner scanner) {
        InputView inputView = new InputView(scanner);
        inputView.parseUserNames();
        inputView.parseUserTrialCount();

        Cars cars = new Cars();
        cars.makeCars(inputView.getUserNames());

        System.out.println("\n" + "실행 결과");
        for (int round = 0; round < Integer.parseInt(inputView.getUserTrialCount()); round++) {
            cars.runCars();
            OutputView.printRacingStatus(cars);
        }
        cars.selectWinners();
        OutputView.printResult(cars);
    }
}

package racingcar;

import java.util.Scanner;
import racingcar.domain.race.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView inputView = InputView.of(scanner);
        OutputView outputView = OutputView.basic();

        start(inputView, outputView);
    }

    private static void start(InputView inputView, OutputView outputView) {
        outputView.printInputCarNamesMessage();
        String carNamesStr = inputView.readCarNames();

        outputView.printInputMovingCountMessage();
        int movingCount = inputView.readMovingCount();

        outputView.printResultMessage();
        Race race = Race.of(carNamesStr, movingCount);
        outputView.printRaceTrack(race);
        race(race, outputView);
        outputView.printWinnerCars(race);
    }

    private static void race(Race race, OutputView outputView) {
        while (!race.isComplete()) {
            race.move();
            outputView.printRaceTrack(race);
            outputView.println();
        }
    }
}

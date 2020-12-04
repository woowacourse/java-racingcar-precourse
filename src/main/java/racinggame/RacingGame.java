package racinggame;

import domain.RaceWinner;
import domain.RacingCars;
import views.InputView;
import views.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private final static String RESULT = "실행 결과";

    private int totalRound;
    private RacingCars racingCars;

    private RacingGame(RacingCars racingCars, int totalRound) {
        this.racingCars = racingCars;
        this.totalRound = totalRound;
    }

    public static RacingGame prepareRacingGame(Scanner scanner) {
        List<String> carName = InputView.inputCarNames(scanner);
        RacingCars racingCars = new RacingCars(carName);

        int round = InputView.inputRoundNumber(scanner);
        return new RacingGame(racingCars, round);
    }

    public void gamePlay() {
        System.out.println();
        System.out.println(RESULT);
        for (int round = 1; round <= totalRound; round++) {
            racingCars.moveAllCar();
            OutputView.printOneRound(racingCars);
        }
    }

    public void gameResult() {
        Referee referee = new Referee();
        referee.calculateMaxDistance(racingCars);

        RaceWinner raceWinner = referee.selectWinner(racingCars);
        OutputView.printWinner(raceWinner);
    }
}

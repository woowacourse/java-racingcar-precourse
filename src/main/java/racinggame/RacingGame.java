package racinggame;

import domain.RacingCars;
import domain.TotalRound;
import views.InputView;
import views.OutputView;

import java.util.Scanner;

public class RacingGame {
    private static final String RESULT = "실행 결과";

    private TotalRound totalRound;
    private RacingCars racingCars;

    private RacingGame(RacingCars racingCars, TotalRound totalRound) {
        this.racingCars = racingCars;
        this.totalRound = totalRound;
    }

    public static RacingGame prepareRacingGame(Scanner scanner) {
        RacingGame newGame = null;
        try {
            RacingCars racingCars = new RacingCars(InputView.inputCarNames(scanner));
            String round = InputView.inputRoundNumber(scanner);
            newGame = new RacingGame(racingCars, new TotalRound(round));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return newGame;
    }

    public void gamePlay() {
        System.out.println();
        System.out.println(RESULT);
        for (int round = 1; round <= totalRound.getTotalRound(); round++) {
            racingCars.moveAllCar();
            OutputView.printOneRound(racingCars);
        }
    }

    public void gameResult() {
        Referee referee = new Referee();
        referee.calculateMaxDistance(racingCars);

        OutputView.printWinner(referee.selectWinner(racingCars));
    }
}

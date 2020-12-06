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
        RacingCars racingCars = new RacingCars(InputView.inputCarNames(scanner));
        String round = InputView.inputRoundNumber(scanner);
        return new RacingGame(racingCars, new TotalRound(round));
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

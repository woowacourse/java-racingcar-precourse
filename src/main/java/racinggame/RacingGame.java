package racinggame;

import domain.RacingCars;
import domain.Referee;
import domain.TotalRound;
import views.InputView;
import views.MovementOutputView;
import views.WinnerOutputView;

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
        while (true) {
            try {
                return new RacingGame(new RacingCars(InputView.inputCarNames(scanner)), new TotalRound(InputView.inputRoundNumber(scanner)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void playGame() {
        System.out.println();
        System.out.println(RESULT);
        for (int round = 1; round <= totalRound.getTotalRound(); round++) {
            racingCars.moveAllCar();
            MovementOutputView.printAllCarMovement(racingCars);
        }
    }

    public void awardGame() {
        Referee referee = new Referee();
        referee.calculateMaxPosition(racingCars);

        WinnerOutputView.printWinner(referee.setWinner(racingCars));
    }
}

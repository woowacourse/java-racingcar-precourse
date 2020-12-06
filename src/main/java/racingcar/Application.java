package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.domain.WinnersCreator;
import racingcar.domain.strategies.RandomNumberStrategy;
import racingcar.views.InputView;
import racingcar.views.OutputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        playRacingGame(scanner);
    }

    private static void playRacingGame(Scanner scanner) {
        List<String> carNames = InputView.inputCarNames(scanner);
        int trialCount = InputView.inputTrialCount(scanner);

        RacingGame racingGame = new RacingGame(carNames, new RandomNumberStrategy());
        playAsManyAsTrialCount(racingGame, trialCount);
        selectAndPrintWinners(racingGame);
    }

    private static void playAsManyAsTrialCount(RacingGame racingGame, int trialCount) {
        OutputView.printResultGuidingMessage();
        for (int trial = 0; trial < trialCount; trial++) {
            racingGame.playOneCycle();
            OutputView.printCurrentStatus(racingGame);
        }
    }

    private static void selectAndPrintWinners(RacingGame racingGame) {
        Winners winners = WinnersCreator.createWinners(racingGame);
        OutputView.printWinners(winners);
    }
}

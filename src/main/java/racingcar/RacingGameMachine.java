package racingcar;

import java.util.Scanner;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class RacingGameMachine {

    private final InputView inputView;

    private final OutputView outputView;

    public RacingGameMachine(final Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
    }

    public void run() {
        final String carNames = inputView.askCarNames();
        final int round = inputView.askRound();

        RacingCars racingCars = new RacingCars(carNames);

        outputView.printGameResult();

        for (int i = 0; i < round; i++) {
            racingCars = racingCars.moveCars();
            outputView.printRoundResult(racingCars);
        }

        outputView.printWinners(racingCars);
    }
}

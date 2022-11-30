package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void generate() {
        RacingCarGame racingCarGame = createRacingGame();
        int racingCount = getRacingCount();
        playRacingGame(racingCarGame, racingCount);

        outputView.printRacingResult(racingCarGame);
    }

    public RacingCarGame createRacingGame() {
        try {
            List<String> cars = inputView.inputCars();
            return new RacingCarGame(cars);

        }catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return createRacingGame();
    }

    public int getRacingCount() {
        try {
            return inputView.inputMovingCount();

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return getRacingCount();
    }

    public void playRacingGame(RacingCarGame racingCarGame, int racingCount) {
        for(int i = 0; i<racingCount; i++) {
            racingCarGame.raceCars();
            outputView.printMovingResult(racingCarGame);
        }
    }
}

package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

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
}

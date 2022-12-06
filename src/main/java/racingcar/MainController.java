package racingcar;

import java.util.List;
import java.util.function.Supplier;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

    private final CarGame carGame;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        carGame = new CarGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        registerCars();
        registerMoveCounts();
        startRace();
        endRace();
    }

    private void registerCars() {
        List<String> inputCars = repeat(inputView::inputCars);
        carGame.registerCar(inputCars);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }

    private void registerMoveCounts() {
        int moveCounts = repeat(inputView::inputMoveCounts);
        carGame.registerMoveCounts(moveCounts);
    }

    private void startRace() {
        outputView.printRaceStart();
        while (!carGame.checkIsOver()) {
            carGame.startRacing();
            outputView.printCars(carGame.getCars());
        }
    }

    private void endRace() {
        outputView.printWinners(carGame.announceWinners());
    }
}

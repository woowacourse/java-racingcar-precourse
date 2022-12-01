package racingcar;

import java.util.List;
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
        while (true) {
            try {
                List<String> inputCars = inputView.inputCars();
                carGame.registerCar(inputCars);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
                continue;
            }
            break;
        }
    }

    private void registerMoveCounts() {
        while (true) {
            try {
                int moveCounts = inputView.inputMoveCounts();
                carGame.registerMoveCounts(moveCounts);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
                continue;
            }
            break;
        }
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

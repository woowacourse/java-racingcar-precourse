package racingcar;

import java.util.List;

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
        List<String> inputCars = inputView.inputCars();
        carGame.registerCar(inputCars);
    }

    private void registerMoveCounts() {
        int moveCounts = inputView.inputMoveCounts();
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

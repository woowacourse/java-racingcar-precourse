package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private RacingGame racingGame;

    public void run() {
        List<Car> cars = generateCars();
        racingGame = new RacingGame(cars);
        play();
    }

    private void play() {
        race();
        RacingResult winner = racingGame.getWinner();
        outputView.printWinner(winner);
    }

    private void race() {
        int count = readCount();
        for (int i = 0; i < count; i++) {
            RacingResult result = racingGame.play();
            outputView.printWay(result);
        }
    }

    private int readCount() {
        try {
            return inputView.readCount();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readCount();
        }
    }

    private List<Car> generateCars() {
        try {
            List<String> names = inputView.readName();
            return names.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return generateCars();
        }
    }
}

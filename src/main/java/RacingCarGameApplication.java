/*
 * RacingCarGameApplication.java
 *
 * v 0.0.0
 *
 * 2019.12.08
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import domain.Cars;
import domain.RacingCarGame;
import domain.RepetitionNumber;
import utlis.CarsUtils;
import view.InputView;
import view.OutputView;

public class RacingCarGameApplication {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Cars cars = createCarsByInput();
        RepetitionNumber repetitionNumber = createRepetitionNumberByInput();
        RacingCarGame racingCarGame = new RacingCarGame(cars, repetitionNumber);

        racingCarGame.startGame();

        outputView.printRaceResults(racingCarGame.createRaceResults());
        outputView.printGameResult(racingCarGame.createGameResult());
    }

    private static Cars createCarsByInput() {
        try {
            String carNames = inputView.inputCarNames();
            return CarsUtils.createCarsByCarNames(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return createCarsByInput();
        }
    }

    private static RepetitionNumber createRepetitionNumberByInput() {
        try {
            int inputRepetitionNumber = inputView.inputRepetitionNumber();
            return new RepetitionNumber(inputRepetitionNumber);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return createRepetitionNumberByInput();
        }
    }
}

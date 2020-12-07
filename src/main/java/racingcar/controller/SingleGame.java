package racingcar.controller;

import racingcar.Car;
import racingcar.domain.TrialProgression;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleGame {
    public void play(Scanner scanner) {
        ArrayList<Car> carsInGame = InputView.getUserCarInput(scanner);
        int numberOfTrial = InputView.getUserTrialInput(scanner);

        TrialProgression trialProgression = new TrialProgression(carsInGame, numberOfTrial);
        trialProgression.progress();
        int finalFrontRunnerPosition = trialProgression.getFrontRunnerPosition();

        OutputView.announceWinner(finalFrontRunnerPosition, carsInGame);
    }
}

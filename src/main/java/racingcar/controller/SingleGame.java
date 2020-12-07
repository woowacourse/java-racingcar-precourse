package racingcar.controller;

import racingcar.Car;
import racingcar.domain.TrialProgression;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleGame {
    private ArrayList<Car> carsInGame;
    private int numberOfTrial;
    private int finalFrontRunnerPosition = 0;

    public void play(Scanner scanner) {
        carsInGame = InputView.getUserCarInput(scanner);
        numberOfTrial = InputView.getUserTrialInput(scanner);

        TrialProgression.trialProgress(numberOfTrial, carsInGame);
        finalFrontRunnerPosition = TrialProgression.getFrontRunnerPosition();

        OutputView.announceWinner(finalFrontRunnerPosition, carsInGame);
    }

}

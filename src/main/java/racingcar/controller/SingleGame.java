package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.TrialProgression;
import racingcar.domain.Winners;
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

        Winners finalWinners = new Winners();
        finalWinners.checkWinners(finalFrontRunnerPosition, carsInGame);
        ArrayList<String> winners = finalWinners.getWinners();

        OutputView.printWinners(winners);
    }
}

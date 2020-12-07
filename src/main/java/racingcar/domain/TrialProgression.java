package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;

public class TrialProgression {
    private ArrayList<Car> carsInGame;
    private int numberOfTrial;
    private int frontRunnerPosition = 0;

    public TrialProgression(ArrayList<Car> carsInGame, int numberOfTrial) {
        this.carsInGame = carsInGame;
        this.numberOfTrial = numberOfTrial;
    }

    public void progress() {
        OutputView.printTrialResultFormat();
        for (int i = 0; i < numberOfTrial; i++) {
            singleTrial();
        }
    }

    public int getFrontRunnerPosition() {
        return frontRunnerPosition;
    }

    private void singleTrial() {
        for (Car car : carsInGame) {
            car.moveOrStop();
            OutputView.printCarName(car);
            OutputView.printPosition(car);
            checkFrontRunner(car);
        }
        System.out.println();
    }

    private void checkFrontRunner(Car car) {
        int carPosition = car.getPosition();
        if (carPosition > frontRunnerPosition) {
            frontRunnerPosition = carPosition;
        }
    }
}

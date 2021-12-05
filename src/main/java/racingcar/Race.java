package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;

public class Race {
    private final ArrayList<Car> cars;
    private final ArrayList<Car> winnerCars = new ArrayList<>();
    private int maxDistance;
    private int moveCount;

    public Race(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        execute();
        calculateMaxDistance();
        decideWinner();
        showWinner();
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    private void calculateMaxDistance() {
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }

    private void decideWinner() {
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winnerCars.add(car);
            }
        }
    }

    private void execute() {
        while (moveCount > 0) {
            for (Car car : cars) {
                car.move();
                car.showPosition();
            }
            OutputView.printNewLine();
            moveCount--;
        }
    }

    private void showWinner() {
        int winnerCount = winnerCars.size();
        String[] winnerCarNames = new String[winnerCount];
        for (int i = 0; i < winnerCount; i++) {
            winnerCarNames[i] = winnerCars.get(i).getName();
        }
        OutputView.printFinalWinnerBy(winnerCarNames);
    }

}

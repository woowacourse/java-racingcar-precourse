package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;

public class Race {
    private ArrayList<Car> cars;
    private ArrayList<Car> winnerCars = new ArrayList<>();
    private int maxDistance;
    private int moveCount;

    public Race(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void calculateMaxDistance() {
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }

    public void decideWinner() {
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winnerCars.add(car);
            }
        }
    }

    public void execute() {
        while (moveCount > 0) {
            for (Car car : cars) {
                car.move();
                car.printPosition();
            }
            OutputView.printNewLine();
            moveCount--;
        }
    }

    public void showWinner() {
        int winnerCount = winnerCars.size();
        String[] winnerCarNames = new String[winnerCount];
        for (int i = 0; i < winnerCount; i++) {
            winnerCarNames[i] = winnerCars.get(i).getName();
        }
        OutputView.printFinalWinnerBy(winnerCarNames);
    }

}

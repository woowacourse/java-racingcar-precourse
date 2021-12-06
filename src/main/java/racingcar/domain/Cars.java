package racingcar.domain;

import racingcar.View.OutputView;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public int calculateMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
        return maxDistance;
    }

    public Cars decideWinner(int maxDistance) {
        ArrayList<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winnerCars.add(car);
            }
        }
        return Cars.of(winnerCars);
    }

    public void executeRound(int moveCount) {
        while (moveCount > 0) {
            for (Car car : cars) {
                car.move();
                car.showPosition();
            }
            OutputView.printNewLine();
            moveCount--;
        }
    }

    public void showWinner() {
        int winnerCount = cars.size();
        String[] winnerCarNames = new String[winnerCount];
        for (int i = 0; i < winnerCount; i++) {
            winnerCarNames[i] = cars.get(i).getName();
        }
        OutputView.printFinalWinnerBy(winnerCarNames);
    }


    public static Cars of(ArrayList<Car> cars) {
        return new Cars(cars);
    }
}

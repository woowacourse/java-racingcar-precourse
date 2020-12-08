package racingcar.domain;

import java.util.ArrayList;

public class Winners {
    private ArrayList<String> winners = new ArrayList<String>();

    public Winners() {
    }

    public void checkWinners(int finalFrontRunnerPosition, ArrayList<Car> carsInGame) {
        for (Car car : carsInGame) {
            if (car.getPosition() == finalFrontRunnerPosition) {
                winners.add(car.getName());
            }
        }
    }

    public ArrayList<String> getWinners() {
        return winners;
    }
}

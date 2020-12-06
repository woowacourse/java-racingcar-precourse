package racingcar.domain;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private final List<Car> carList;

    public GameBoard(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> runRound() {
        for (int idx = 0; idx < this.carList.size(); idx++) {
            this.carList.get(idx).move();
        }
        return this.carList;
    }

    public List<Car> getWinner() {
        List<Car> winnerList = new ArrayList<Car>;
        int maxScore = 0;
        for (int idx = 0; idx < this.carList.size(); idx++) {
            Car car = this.carList.get(idx);
            if (car.getPosition() > maxScore) {
                maxScore = car.getPosition();
                winnerList.clear();
                winnerList.add(car);
            }
            if (car.getPosition() == maxScore) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }
}

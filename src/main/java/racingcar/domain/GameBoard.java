package racingcar.domain;

import racingcar.domain.Car;

import java.util.List;

public class GameBoard {
    private List<Car> carList;

    public GameBoard(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> runRound() {
        for (int idx = 0; idx < this.carList.size(); idx++) {
            this.carList.get(idx).move();
        }
        return this.carList;
    }
}

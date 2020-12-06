package racingcar.domain;

import racingcar.domain.Car;

import java.util.List;

public class Scoreboard {
    private final List<Car> carList;

    public Scoreboard(List<Car> carList) {
        this.carList = carList;
    }

    public void runRound() {
        for (int idx = 0; idx < this.carList.size(); idx++) {
            this.carList.get(idx).move();
        }
    }
}

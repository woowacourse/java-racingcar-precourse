package racingcar;

import java.util.HashMap;

public class ScoreBoard {
    HashMap<Car, Integer> scores = new HashMap<>();

    public void addScore(Car car) {
        scores.put(car, scores.get(car) + 1);
    }

    public void initiate(Cars cars) {
        for (Car car : cars.getCars()) {
            this.scores.put(car, 0);
        }
    }
}

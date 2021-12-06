package racingcar.gameresult;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;

public class RacingResults {
    List<RacingResult> racingResults;

    public RacingResults(List<Car> cars) {
        this.racingResults = new ArrayList<>();
        addRacingResults(cars);
    }

    public void addRacingResults(List<Car> cars) {
        for (Car car : cars) {
            racingResults.add(new RacingResult(car));
        }
    }

    public List<RacingResult> getRacingResults() {
        return racingResults;
    }
}

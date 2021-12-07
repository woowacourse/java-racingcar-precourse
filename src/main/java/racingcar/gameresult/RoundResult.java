package racingcar.gameresult;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;

public class RoundResult {
    List<RacingResult> racingResults;

    public RoundResult(List<Car> cars) {
        this.racingResults = new ArrayList<>();
        addRacingResults(cars);
    }

    public void addRacingResults(List<Car> cars) {
        cars.forEach(car -> racingResults.add(new RacingResult(car)));
    }

    public List<RacingResult> getRacingResults() {
        return racingResults;
    }
}

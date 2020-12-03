package racingcar;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private Winners winners;
    private List<Car> cars;

    private RaceResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RaceResult of(List<Car> cars) {
        RaceResult raceResult = new RaceResult(cars);
        List<Car> winnerList = raceResult.getWinnerList();
        raceResult.winners = new Winners(winnerList);
        return raceResult;
    }

    private List<Car> getWinnerList() {
        return cars.stream()
                .filter(car -> car.getCurrentPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinnersName(){
        return winners.getWinnersName();
    }
}

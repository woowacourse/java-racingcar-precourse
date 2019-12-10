package system;

import domain.Car;
import io.OutputRacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RankingSystem {
    private List<Car> racingCars;

    public RankingSystem(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public void startRanking() {
        List<String> winnerList = getWinnerList();
        OutputRacingCar.printWinner(winnerList);
    }

    private List<String> getWinnerList() {
        int maxPosition = getMaxPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return racingCars.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();
    }
}
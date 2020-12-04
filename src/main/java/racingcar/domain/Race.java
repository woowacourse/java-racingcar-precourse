package racingcar.domain;

import racingcar.domain.engine.RandomEngine;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private RacingCars racingCars;
    private int numOfMove;
    private StringBuilder racingResult = new StringBuilder();

    public Race(List<String> carsNames, int numOfMove) {
        prepareRacingCars(carsNames);
        this.numOfMove = numOfMove;
    }

    private void prepareRacingCars(List<String> carsNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carsNames) {
            cars.add(new Car(carName));
        }
        this.racingCars = new RacingCars(cars);
    }

    public void start() {
        RandomEngine randomEngine = new RandomEngine();

        for (int i = 0; i < numOfMove; i++) {
            racingResult
                    .append(racingCars.move(randomEngine))
                    .append("\n");
        }

        racingResult
                .append("최종 우승자: ")
                .append(getFastestCarsName());
    }

    private String getFastestCarsName() {
        List<Car> fastestCars = racingCars.getFastestCars();

        int numOfFastestCar = fastestCars.size();
        String[] fastestCarsName = new String[numOfFastestCar];
        for (int i = 0; i < numOfFastestCar; i++) {
            fastestCarsName[i] = fastestCars.get(i).getName();
        }

        return String.join(",", fastestCarsName);
    }

    public String getRacingResult() {
        return this.racingResult.toString();
    }
}

package racingcar.service;

import racingcar.controller.dto.NameDto;
import racingcar.controller.dto.TrialDto;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Number;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceService {

    private static int RACE_TRY = 1;

    private final Number number;

    private Cars cars;
    private int trial;

    public CarRaceService(Number number) {
        this.number = number;
    }

    public void saveCarName(NameDto dto) {
        List<Car> cars = dto.getNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(cars);
    }

    public void saveTrial(TrialDto dto) {
        this.trial = dto.getTrial();
    }

    public boolean isEnd() {
        return this.trial > 0;
    }

    public Cars race() {
        cars.race(number);
        trial -= RACE_TRY;
        return cars;
    }
}
